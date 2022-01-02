package io.arkitik.clef.workflow.api.adapter.task.updater

import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.task.updater.TaskUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskUpdaterImpl(
    private val task: Task,
) : TaskUpdater {
    override fun disable(): TaskUpdater {
        task.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): TaskUpdater {
        task.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): TaskUpdater {
        task.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update() = task

}
