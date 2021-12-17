package io.quee.clef.workflow.api.store.task.updater

import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageTaskUpdater : StoreIdentityUpdater<String, StageTaskIdentity> {
    fun TaskActionIdentity.addAction(): StageTaskUpdater
    fun MutableList<TaskActionIdentity>.addActions(): StageTaskUpdater

    fun disable(): StageTaskUpdater
    fun enable(): StageTaskUpdater
    fun delete(): StageTaskUpdater
}