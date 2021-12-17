package io.quee.clef.workflow.api.adapter.workflow.query

import io.arkitik.radix.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.entity.workflow.Workflow
import io.quee.clef.workflow.api.entity.workflow.WorkflowStage
import io.quee.clef.workflow.api.adapter.workflow.repository.WorkflowRepository
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
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