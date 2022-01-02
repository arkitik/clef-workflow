package io.arkitik.clef.workflow.api.adapter.task.query

import io.arkitik.clef.workflow.api.adapter.task.repository.TaskRepository
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.task.query.TaskStoreQuery
import io.arkitik.radix.adapter.shared.query.StoreQueryImpl

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskStoreQueryImpl(
    private val taskRepository: TaskRepository,
) : StoreQueryImpl<String, TaskIdentity, Task>(taskRepository), TaskStoreQuery {
    override fun findByKey(taskKey: String): TaskIdentity? =
        taskRepository.findByTaskKey(taskKey)

    override fun existByKey(domainKey: String): Boolean =
        taskRepository.existsByTaskKey(domainKey)

    override fun findAllByStage(stage: StageIdentity) =
        taskRepository.findAllByStage(stage as Stage)

}
