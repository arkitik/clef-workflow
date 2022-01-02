package io.arkitik.clef.workflow.api.usecase.domain.stage.main

import io.arkitik.clef.workflow.api.common.error.StageResponses
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.store.stage.query.InitialStageStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.workflow.WorkflowDomainRequest
import io.arkitik.radix.develop.shared.ext.unprocessableEntity
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.adapter.toResponse

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 8:13 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class FindWorkflowInitialStageUseCase(
    private val initialStageStoreQuery: InitialStageStoreQuery,
) : FunctionalUseCase<WorkflowDomainRequest, ResponseAdapter<StageIdentity>> {
    override fun WorkflowDomainRequest.process(): ResponseAdapter<StageIdentity> {
        val initialStageIdentity = initialStageStoreQuery.findByWorkflow(
            workflow
        ) ?: throw StageResponses.Errors.WORKFLOW_DOES_NOT_HAVE_INITIAL_STAGE.unprocessableEntity()
        return toResponse {
            initialStageIdentity.stage
        }
    }
}
