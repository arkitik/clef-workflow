package io.arkitik.clef.workflow.api.usecase.domain.stage.main

import io.arkitik.clef.workflow.api.store.stage.query.InitialStageStoreQuery
import io.arkitik.clef.workflow.api.store.stage.query.StageStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.workflow.WorkflowDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.response.stage.WorkflowStagesResponse
import io.arkitik.radix.develop.usecase.FunctionalUseCase

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 8:13 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class FindWorkflowStagesUseCase(
    private val stageStoreQuery: StageStoreQuery,
    private val initialStageStoreQuery: InitialStageStoreQuery,
) : FunctionalUseCase<WorkflowDomainRequest, WorkflowStagesResponse> {
    override fun WorkflowDomainRequest.process(): WorkflowStagesResponse {
        val stages = with(stageStoreQuery) {
            findAllByWorkflow(workflow)
        }
        val initialStageIdentity = initialStageStoreQuery.findByWorkflow(workflow)
        return WorkflowStagesResponse(
            initialStage = initialStageIdentity?.stage,
            stages
        )
    }
}
