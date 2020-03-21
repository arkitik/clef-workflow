package io.quee.clef.workflow.api.usecase.domain.workflow.main

import io.quee.api.develop.shared.exception.ResourceNotFoundException
import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.error.SharedErrors
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **21**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FindWorkflowByStageUseCase(
        private val workflowStoreQuery: WorkflowStoreQuery
) : FunctionalUseCase<RequestAdapter<StageIdentity>, ResponseAdapter<WorkflowIdentity>> {
    override fun RequestAdapter<StageIdentity>.process(): ResponseAdapter<WorkflowIdentity> {
        val stageIdentity = workflowStoreQuery.findByStage(request)
        if (stageIdentity != null) {
            stageIdentity.validate()
            return ResponseAdapter(stageIdentity)
        }
        throw ResourceNotFoundException(WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
    }

    private fun Identity.validate() {
        if (identityStatus == IdentityStatus.DELETED) throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DELETED_ERROR)
        else if (identityStatus == IdentityStatus.DISABLED) throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DISABLED_ERROR)
    }
}