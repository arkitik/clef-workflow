package io.quee.clef.workflow.api.adapter.action.updater

import io.quee.clef.workflow.api.entity.workflow.TaskAction
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.store.action.updater.TaskActionUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionUpdaterImpl(
    private val taskAction: TaskAction,
) : TaskActionUpdater {
    override fun disable(): TaskActionUpdater {
        taskAction.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): TaskActionUpdater {
        taskAction.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): TaskActionUpdater {
        taskAction.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update(): TaskActionIdentity = taskAction
}