package io.arkitik.clef.workflow.api.adapter.stage.repository

import io.arkitik.radix.adapter.shared.repository.RadixRepository
import io.arkitik.clef.workflow.api.entity.workflow.StageTask
import io.arkitik.clef.workflow.api.entity.workflow.WorkflowStage
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Repository
interface WorkflowStageRepository : RadixRepository<String, WorkflowStage> {
    fun findByStageKey(workflowKey: String): WorkflowStage?
    fun existsByStageKey(workflowKey: String): Boolean

    fun findByTasksInOrInitialTaskIn(tasks: List<StageTask>, initialTask: List<StageTask>): WorkflowStage?
}