package io.arkitik.clef.workflow.api.store.task

import io.arkitik.clef.workflow.api.domain.task.InitialTaskIdentity
import io.arkitik.clef.workflow.api.store.task.creator.InitialTaskCreator
import io.arkitik.clef.workflow.api.store.task.query.InitialTaskStoreQuery
import io.arkitik.clef.workflow.api.store.task.updater.InitialTaskUpdater
import io.arkitik.radix.develop.store.Store

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface InitialTaskStore : Store<String, InitialTaskIdentity> {
    override val storeQuery: InitialTaskStoreQuery

    override fun identityCreator(): InitialTaskCreator

    override fun InitialTaskIdentity.identityUpdater(): InitialTaskUpdater
}
