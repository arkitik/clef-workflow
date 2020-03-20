package io.quee.clef.workflow.api.store.element

import io.quee.api.develop.store.Store
import io.quee.api.develop.store.StoreIdentityUpdater
import io.quee.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.quee.clef.workflow.api.store.element.creator.ElementFlowIdentityCreator
import io.quee.clef.workflow.api.store.element.query.ElementFlowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementFlowStore : Store<ElementFlowIdentity> {
    override val storeQuery: ElementFlowStoreQuery
    override fun identityCreator(): ElementFlowIdentityCreator

    override fun ElementFlowIdentity.identityUpdater(): StoreIdentityUpdater<ElementFlowIdentity> {
        error("Not supported")
    }
}