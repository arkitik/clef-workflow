package io.arkitik.clef.workflow.api.adapter.task

import io.arkitik.clef.workflow.api.adapter.task.creator.TaskCreatorImpl
import io.arkitik.clef.workflow.api.adapter.task.query.TaskStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.task.repository.TaskRepository
import io.arkitik.clef.workflow.api.adapter.task.updater.TaskUpdaterImpl
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.task.TaskStore
import io.arkitik.radix.adapter.shared.StoreImpl
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class TaskStoreImpl(
    taskRepository: TaskRepository,
) : StoreImpl<String, TaskIdentity, Task>(taskRepository), TaskStore {
    override fun TaskIdentity.map() = this as Task

    override val storeQuery =
        TaskStoreQueryImpl(taskRepository)

    override fun identityCreator() =
        TaskCreatorImpl()

    override fun TaskIdentity.identityUpdater() =
        TaskUpdaterImpl(this as Task)
}
