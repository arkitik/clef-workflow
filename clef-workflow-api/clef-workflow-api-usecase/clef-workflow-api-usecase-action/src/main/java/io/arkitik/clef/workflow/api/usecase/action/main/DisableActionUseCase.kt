package io.arkitik.clef.workflow.api.usecase.action.main

import io.arkitik.clef.workflow.api.common.error.TaskActionResponses
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.action.ActionStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest
import io.arkitik.radix.develop.store.storeUpdater
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DisableActionUseCase(
    private val actionStore: ActionStore,
    private val identityStatusValidation: IdentityStatusValidation,
    private val actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskActionRequest, SharedResponse>() {
    override fun TaskActionRequest.doProcess(): SharedResponse {
        val action = actionDomainUseCaseFactory.functional {
            findActionByKeyUseCase
        }.process(FindDomainByKeyRequest(actionKey, false)).response
        action.identityStatus.validate()
        actionStore.run {
            storeUpdater(action.identityUpdater()) {
                delete()
                update()
            }.save()
        }
        return TaskActionResponses.TASK_ACTION_DISABLED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DISABLED)
        }
    }
}
