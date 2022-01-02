package io.arkitik.clef.workflow.api.store.stage

import io.arkitik.clef.workflow.api.domain.stage.InitialStageIdentity
import io.arkitik.clef.workflow.api.store.stage.creator.InitialStageCreator
import io.arkitik.clef.workflow.api.store.stage.query.InitialStageStoreQuery
import io.arkitik.clef.workflow.api.store.stage.updater.InitialStageUpdater
import io.arkitik.radix.develop.store.Store

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface InitialStageStore : Store<String, InitialStageIdentity> {
    override val storeQuery: InitialStageStoreQuery

    override fun identityCreator(): InitialStageCreator

    override fun InitialStageIdentity.identityUpdater(): InitialStageUpdater
}
