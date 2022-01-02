package io.arkitik.clef.workflow.api.adapter.stage.repository

import io.arkitik.clef.workflow.api.entity.stage.InitialStage
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.radix.adapter.shared.repository.RadixRepository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface InitialStageRepository : RadixRepository<String, InitialStage> {
    fun existsByWorkflow(workflow: Workflow): Boolean
    fun findByWorkflow(workflow: Workflow): InitialStage?
}
