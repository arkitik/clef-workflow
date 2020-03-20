package io.quee.clef.workflow.api.adapter.task.updater

import io.quee.clef.workflow.api.adapter.entity.workflow.StageTask
import io.quee.clef.workflow.api.adapter.entity.workflow.TaskAction
import io.quee.clef.workflow.api.adapter.shared.entity.BaseIdentity
import io.quee.clef.workflow.api.adapter.shared.updater.BaseStoreIdentityUpdater
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.task.updater.StageTaskUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageTaskUpdaterImpl(
        private val stageTask: StageTask
) : BaseStoreIdentityUpdater<StageTaskIdentity>(), StageTaskUpdater {
    override fun entity(): BaseIdentity = stageTask

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

    override fun update(): StageTaskIdentity = stageTask

}