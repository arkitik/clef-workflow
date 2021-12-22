package io.arkitik.clef.workflow.api.adapter.workflow.query

import io.arkitik.radix.adapter.shared.query.StoreQueryImpl
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.entity.workflow.WorkflowStage
import io.arkitik.clef.workflow.api.adapter.workflow.repository.WorkflowRepository
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.store.workflow.query.WorkflowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class WorkflowStoreQueryImpl(
    private val workflowRepository: WorkflowRepository,
) : StoreQueryImpl<String, WorkflowIdentity, Workflow>(workflowRepository), WorkflowStoreQuery {
    override fun findByKey(workflowKey: String): WorkflowIdentity? =
        workflowRepository.findByWorkflowKey(workflowKey)

    override fun existsByKeyAndUuid(workflowKey: String, workflowUuid: String): Boolean =
        workflowRepository.existsByWorkflowKeyAndUuid(workflowKey, workflowUuid)

    override fun existByKey(workflowKey: String): Boolean =
        workflowRepository.existsByWorkflowKey(workflowKey)

    override fun findByStage(stageIdentity: StageIdentity): WorkflowIdentity? {
        val stages = listOf(stageIdentity as WorkflowStage)
        return workflowRepository.findByStagesInOrInitialStageIn(stages, stages)
    }
}