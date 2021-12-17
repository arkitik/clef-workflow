package io.quee.clef.workflow.api.usecase.workflow.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DisableWorkflowUseCase(
    private val workflowStore: WorkflowStore,
    private val identityStatusValidation: IdentityStatusValidation,
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : ValidationFunctionalUseCase<WorkflowRequest, SharedResponse>() {

    override fun WorkflowRequest.doProcess(): SharedResponse {
        val workflow = workflowDomainUseCaseFactory.findWorkflowByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(workflowKey, false)
                    .process()
                    .response
            }
        workflow.identityStatus.validate()
        workflowStore.run {
            workflow.identityUpdater()
                .disable()
                .update()
                .save()
        }
        return WorkflowResponses.WORKFLOW_DISABLED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DISABLED)
        }
    }
}