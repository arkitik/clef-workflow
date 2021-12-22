package io.arkitik.clef.workflow.api.store.stage.updater

import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageIdentityUpdater : StoreIdentityUpdater<String, StageIdentity> {
    fun StageTaskIdentity.initialTask(): StageIdentityUpdater
    fun StageTaskIdentity.addTask(): StageIdentityUpdater
    fun MutableList<StageTaskIdentity>.addTasks(): StageIdentityUpdater

    fun disable(): StageIdentityUpdater
    fun enable(): StageIdentityUpdater
    fun delete(): StageIdentityUpdater
}