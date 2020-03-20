package io.quee.clef.workflow.api.store.element

import io.quee.api.develop.store.Store
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.store.element.creator.ElementIdentityCreator
import io.quee.clef.workflow.api.store.element.query.ElementStoreQuery
import io.quee.clef.workflow.api.store.element.updater.ElementIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementStore : Store<ElementIdentity> {
    override val storeQuery: ElementStoreQuery
    override fun identityCreator(): ElementIdentityCreator
    override fun ElementIdentity.identityUpdater(): ElementIdentityUpdater
}