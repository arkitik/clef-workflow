package io.quee.clef.workflow.api.usecase.workflow.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DeleteWorkflowUseCase(
        private val workflowStore: WorkflowStore,
        private val identityStatusValidation: IdentityStatusValidation
) : ValidationFunctionalUseCase<WorkflowRequest<UseCaseRequest>, SharedResponse>() {

    override fun WorkflowRequest<UseCaseRequest>.realProcess(): SharedResponse {
        val workflow = workflowStore.storeQuery.findByKeyAndUuid(workflowKey, workflowUuid)
        when {
            workflow != null -> {
                workflow.identityStatus.validate()
                workflowStore.run {
                    workflow.identityUpdater()
                            .delete()
                            .update()
                            .save()
                }
                return WorkflowResponses.WORKFLOW_DELETED_SUCCESS
            }
            else -> throw NotAcceptableException(WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
        }
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DELETED)
        }
    }
}