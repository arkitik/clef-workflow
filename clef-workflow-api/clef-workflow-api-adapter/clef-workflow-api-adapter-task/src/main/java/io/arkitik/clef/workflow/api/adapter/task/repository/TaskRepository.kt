package io.arkitik.clef.workflow.api.adapter.task.repository

import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.radix.adapter.shared.repository.RadixRepository
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Repository
interface TaskRepository : RadixRepository<String, Task> {
    fun findByTaskKey(taskKey: String): Task?
    fun existsByTaskKey(taskKey: String): Boolean

    fun findAllByStage(stage: Stage): List<Task>
}
