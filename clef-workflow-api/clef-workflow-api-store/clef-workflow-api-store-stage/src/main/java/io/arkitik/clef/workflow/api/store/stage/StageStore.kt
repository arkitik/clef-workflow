package io.arkitik.clef.workflow.api.store.stage

import io.arkitik.radix.develop.store.Store
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.store.stage.creator.StageCreator
import io.arkitik.clef.workflow.api.store.stage.query.StageStoreQuery
import io.arkitik.clef.workflow.api.store.stage.updater.StageUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageStore : Store<String, StageIdentity> {
    override val storeQuery: StageStoreQuery

    override fun identityCreator(): StageCreator

    override fun StageIdentity.identityUpdater(): StageUpdater
}
