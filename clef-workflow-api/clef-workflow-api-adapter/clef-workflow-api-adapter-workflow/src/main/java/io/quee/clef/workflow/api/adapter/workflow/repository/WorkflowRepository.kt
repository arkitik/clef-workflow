package io.quee.clef.workflow.api.adapter.workflow.repository

import io.arkitik.radix.adapter.shared.repository.RadixRepository
import io.quee.clef.workflow.api.entity.workflow.Workflow
import io.quee.clef.workflow.api.entity.workflow.WorkflowStage
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Repository
interface WorkflowRepository : RadixRepository<String, Workflow> {
    fun findByWorkflowKey(workflowKey: String): Workflow?
    fun existsByWorkflowKeyAndUuid(workflowKey: String, uuid: String): Boolean
    fun existsByWorkflowKey(workflowKey: String): Boolean

    fun findByStagesInOrInitialStageIn(stages: List<WorkflowStage>, initialStage: List<WorkflowStage>): Workflow?
}