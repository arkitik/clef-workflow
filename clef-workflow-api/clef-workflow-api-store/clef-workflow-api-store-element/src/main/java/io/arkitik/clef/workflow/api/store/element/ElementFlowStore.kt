package io.arkitik.clef.workflow.api.store.element

import io.arkitik.radix.develop.store.Store
import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import io.arkitik.clef.workflow.api.domain.element.ElementFlowIdentity
import io.arkitik.clef.workflow.api.store.element.creator.ElementFlowIdentityCreator
import io.arkitik.clef.workflow.api.store.element.query.ElementFlowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementFlowStore : Store<String, ElementFlowIdentity> {
    override val storeQuery: ElementFlowStoreQuery
    override fun identityCreator(): ElementFlowIdentityCreator

    override fun ElementFlowIdentity.identityUpdater(): StoreIdentityUpdater<String, ElementFlowIdentity> {
        error("Not supported")
    }
}
