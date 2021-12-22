package io.arkitik.clef.workflow.api.usecase.action.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.error.TaskActionResponses
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.action.TaskActionStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DisableTaskActionUseCase(
    private val actionStoreQuery: TaskActionStore,
    private val identityStatusValidation: IdentityStatusValidation,
    private val taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskActionRequest, SharedResponse>() {
    override fun TaskActionRequest.doProcess(): SharedResponse {
        val taskAction = taskActionDomainUseCaseFactory.findTaskActionByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(actionKey, false)
                    .process()
                    .response
            }
        taskAction.identityStatus.validate()
        actionStoreQuery.run {
            taskAction.identityUpdater()
                .disable()
                .update()
                .save()
        }
        return TaskActionResponses.TASK_ACTION_DISABLED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DISABLED)
        }
    }
}