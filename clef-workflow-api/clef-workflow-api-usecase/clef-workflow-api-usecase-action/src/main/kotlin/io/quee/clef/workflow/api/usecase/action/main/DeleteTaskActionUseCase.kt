package io.quee.clef.workflow.api.usecase.action.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.clef.workflow.api.common.error.TaskActionResponses
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DeleteTaskActionUseCase(
        private val identityStatusValidation: IdentityStatusValidation,
        private val taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory
) : ValidationFunctionalUseCase<TaskActionRequest, SharedResponse>() {
    override fun TaskActionRequest.realProcess(): SharedResponse {
        val taskAction = taskActionDomainUseCaseFactory.findTaskActionByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(actionKey, actionUuid)
                            .process()
                            .response
                }
        taskAction.identityStatus.validate()
        taskActionDomainUseCaseFactory.deleteAllActionsUseCase
                .run {
                    RequestAdapter(listOf(taskAction)).execute()
                }
        return TaskActionResponses.TASK_ACTION_DELETED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DELETED)
        }
    }
}