package io.arkitik.clef.workflow.api.store.action.updater

import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import io.arkitik.clef.workflow.api.domain.action.ActionIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionUpdater : StoreIdentityUpdater<String, ActionIdentity> {
    fun disable(): ActionUpdater
    fun enable(): ActionUpdater
    fun delete(): ActionUpdater

}
