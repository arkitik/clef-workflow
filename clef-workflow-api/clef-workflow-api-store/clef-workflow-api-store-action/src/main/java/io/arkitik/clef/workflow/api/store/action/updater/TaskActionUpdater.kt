package io.arkitik.clef.workflow.api.store.action.updater

import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskActionUpdater : StoreIdentityUpdater<String, TaskActionIdentity> {
    fun disable(): TaskActionUpdater
    fun enable(): TaskActionUpdater
    fun delete(): TaskActionUpdater

}