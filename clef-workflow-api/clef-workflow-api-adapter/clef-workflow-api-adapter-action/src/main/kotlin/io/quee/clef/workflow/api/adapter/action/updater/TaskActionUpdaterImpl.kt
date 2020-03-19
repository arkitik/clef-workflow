package io.quee.clef.workflow.api.adapter.action.updater

import io.quee.clef.workflow.api.adapter.entity.TaskAction
import io.quee.clef.workflow.api.adapter.shared.entity.BaseIdentity
import io.quee.clef.workflow.api.adapter.shared.updater.BaseStoreIdentityUpdater
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.store.action.updater.TaskActionUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionUpdaterImpl(
        private val taskAction: TaskAction
) : BaseStoreIdentityUpdater<TaskActionIdentity>(), TaskActionUpdater {
    override fun entity(): BaseIdentity = taskAction

    override fun update(): TaskActionIdentity = taskAction
}