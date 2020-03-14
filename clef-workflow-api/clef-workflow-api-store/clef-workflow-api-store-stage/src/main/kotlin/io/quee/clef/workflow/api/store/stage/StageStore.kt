package io.quee.clef.workflow.api.store.stage

import io.quee.api.develop.store.Store
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.stage.creator.StageIdentityCreator
import io.quee.clef.workflow.api.store.stage.query.StageStoreQuery
import io.quee.clef.workflow.api.store.stage.updater.StageIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface StageStore : Store<StageIdentity> {
    override val storeQuery: StageStoreQuery

    override fun identityCreator(): StageIdentityCreator

    override fun StageIdentity.identityUpdater(): StageIdentityUpdater
}