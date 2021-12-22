package io.arkitik.clef.workflow.api.usecase.domain.workflow.main

import io.arkitik.radix.develop.shared.exception.ResourceNotFoundException
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.clef.workflow.api.common.error.WorkflowResponses
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.store.workflow.query.WorkflowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **21**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class FindWorkflowByStageUseCase(
    private val workflowStoreQuery: WorkflowStoreQuery,
) : FunctionalUseCase<RequestAdapter<StageIdentity>, ResponseAdapter<WorkflowIdentity>> {
    override fun RequestAdapter<StageIdentity>.process(): ResponseAdapter<WorkflowIdentity> {
        val stageIdentity = workflowStoreQuery.findByStage(request)
        if (stageIdentity != null) {
            stageIdentity.validate()
            return ResponseAdapter(stageIdentity)
        }
        throw ResourceNotFoundException(WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
    }

    private fun WorkflowIdentity.validate() {
        if (identityStatus == IdentityStatus.DELETED) throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DELETED_ERROR)
        else if (identityStatus == IdentityStatus.DISABLED) throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DISABLED_ERROR)
    }
}