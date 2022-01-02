package io.arkitik.clef.workflow.api.usecase.workflow.main

import io.arkitik.clef.workflow.api.common.error.WorkflowResponses
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.workflow.WorkflowStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.arkitik.radix.develop.store.storeUpdater
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DisableWorkflowUseCase(
    private val workflowStore: WorkflowStore,
    private val identityStatusValidation: IdentityStatusValidation,
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : ValidationFunctionalUseCase<WorkflowRequest, SharedResponse>() {

    override fun WorkflowRequest.doProcess(): SharedResponse {
        val workflow = workflowDomainUseCaseFactory.functional {
            findWorkflowByKeyUseCase
        }.process(FindDomainByKeyRequest(workflowKey, false)).response
        workflow.identityStatus.validate()
        with(workflowStore) {
            storeUpdater(workflow.identityUpdater()) {
                disable()
                update()
            }.save()
        }
        return WorkflowResponses.WORKFLOW_DISABLED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DISABLED)
        }
    }
}
