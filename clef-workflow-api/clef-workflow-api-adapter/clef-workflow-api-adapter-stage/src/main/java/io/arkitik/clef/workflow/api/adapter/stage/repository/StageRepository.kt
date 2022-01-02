package io.arkitik.clef.workflow.api.adapter.stage.repository

import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.radix.adapter.shared.repository.RadixRepository
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Repository
interface StageRepository : RadixRepository<String, Stage> {
    fun findByStageKey(workflowKey: String): Stage?
    fun existsByStageKey(workflowKey: String): Boolean

    fun findAllByWorkflow(workflow: Workflow): List<Stage>
}
