package io.quee.clef.workflow.api.usecase.action.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.error.TaskActionResponses
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.action.TaskActionStore
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class EnableTaskActionUseCase(
    private val actionStoreQuery: TaskActionStore,
    private val identityStatusValidation: IdentityStatusValidation,
    private val taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskActionRequest, SharedResponse>() {
    override fun TaskActionRequest.doProcess(): SharedResponse {
        val taskAction = taskActionDomainUseCaseFactory.findTaskActionByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(actionKey, true)
                    .process()
                    .response
            }
        taskAction.identityStatus.validate()
        actionStoreQuery.run {
            taskAction.identityUpdater()
                .enable()
                .update()
                .save()
        }
        return TaskActionResponses.TASK_ACTION_ENABLED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.ENABLED)
        }
    }
}