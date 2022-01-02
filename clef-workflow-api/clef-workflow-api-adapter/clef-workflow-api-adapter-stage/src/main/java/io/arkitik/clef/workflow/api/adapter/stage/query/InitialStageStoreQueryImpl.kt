package io.arkitik.clef.workflow.api.adapter.stage.query

import io.arkitik.clef.workflow.api.adapter.stage.repository.InitialStageRepository
import io.arkitik.clef.workflow.api.domain.stage.InitialStageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.entity.stage.InitialStage
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.store.stage.query.InitialStageStoreQuery
import io.arkitik.radix.adapter.shared.query.StoreQueryImpl

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:41 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class InitialStageStoreQueryImpl(
    private val initialStageRepository: InitialStageRepository,
) : StoreQueryImpl<String, InitialStageIdentity, InitialStage>(
    initialStageRepository
), InitialStageStoreQuery {
    override fun existsByWorkflow(workflow: WorkflowIdentity) =
        initialStageRepository.existsByWorkflow(workflow as Workflow)

    override fun findByWorkflow(workflow: WorkflowIdentity) =
        initialStageRepository.findByWorkflow(workflow as Workflow)
}
