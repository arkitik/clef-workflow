package io.arkitik.clef.workflow.api.store.task.updater

import io.arkitik.clef.workflow.api.domain.task.InitialTaskIdentity
import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface InitialTaskUpdater : StoreIdentityUpdater<String, InitialTaskIdentity>
