package io.arkitik.clef.workflow.api.store.element

import io.arkitik.radix.develop.store.Store
import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.store.element.creator.ElementIdentityCreator
import io.arkitik.clef.workflow.api.store.element.query.ElementStoreQuery
import io.arkitik.clef.workflow.api.store.element.updater.ElementIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementStore : Store<String, ElementIdentity> {
    override val storeQuery: ElementStoreQuery
    override fun identityCreator(): ElementIdentityCreator
    override fun ElementIdentity.identityUpdater(): ElementIdentityUpdater
}