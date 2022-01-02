package io.arkitik.clef.workflow.api.adapter.task.repository

import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.task.InitialTask
import io.arkitik.radix.adapter.shared.repository.RadixRepository
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Repository
interface InitialTaskRepository : RadixRepository<String, InitialTask> {
    fun findByStage(stage: Stage): InitialTask?
    fun existsByStage(stage: Stage): Boolean
}
