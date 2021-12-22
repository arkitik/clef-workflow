package io.arkitik.clef.workflow.api.usecase.task.main

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.error.StageTaskResponses
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DeleteTaskUseCase(
    private val identityStatusValidation: IdentityStatusValidation,
    private val taskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskRequest, SharedResponse>() {
    override fun TaskRequest.doProcess(): SharedResponse {
        val stageTaskIdentity = taskDomainUseCaseFactory.findStageTaskByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(taskKey, false)
                    .process()
                    .response
            }
        stageTaskIdentity.identityStatus.validate()
        taskDomainUseCaseFactory.deleteAllTasksUseCase
            .run {
                RequestAdapter(listOf(stageTaskIdentity)).execute()
            }
        return StageTaskResponses.TASK_DELETED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DELETED)
        }
    }
}