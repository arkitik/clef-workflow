package io.quee.clef.workflow.api.adapter.task.updater

import io.quee.clef.workflow.api.entity.workflow.StageTask
import io.quee.clef.workflow.api.entity.workflow.TaskAction
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.task.updater.StageTaskUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageTaskUpdaterImpl(
    private val stageTask: StageTask,
) : StageTaskUpdater {
    override fun TaskActionIdentity.addAction(): StageTaskUpdater {
        stageTask.actions.add(this as TaskAction)
        return this@StageTaskUpdaterImpl
    }

    override fun MutableList<TaskActionIdentity>.addActions(): StageTaskUpdater {
        stageTask.actions.addAll(map {
            it as TaskAction
        })
        return this@StageTaskUpdaterImpl
    }

    override fun disable(): StageTaskUpdater {
        stageTask.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): StageTaskUpdater {
        stageTask.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): StageTaskUpdater {
        stageTask.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update(): StageTaskIdentity = stageTask

}