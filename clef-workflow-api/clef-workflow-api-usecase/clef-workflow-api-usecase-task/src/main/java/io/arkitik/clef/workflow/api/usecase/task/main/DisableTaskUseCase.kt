package io.arkitik.clef.workflow.api.usecase.task.main

import io.arkitik.clef.workflow.api.common.error.StageTaskResponses
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.task.TaskStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.arkitik.radix.develop.store.storeUpdater
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DisableTaskUseCase(
    private val taskStore: TaskStore,
    private val identityStatusValidation: IdentityStatusValidation,
    private val taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskRequest, SharedResponse>() {
    override fun TaskRequest.doProcess(): SharedResponse {
        val stageTaskIdentity = taskDomainUseCaseFactory.functional {
            findTaskByKeyUseCase
        }.process(FindDomainByKeyRequest(taskKey, false)).response
        stageTaskIdentity.identityStatus.validate()
        with(taskStore) {
            storeUpdater(stageTaskIdentity.identityUpdater()) {
                disable()
                update()
            }.save()
        }
        return StageTaskResponses.TASK_DISABLED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DISABLED)
        }
    }
}
