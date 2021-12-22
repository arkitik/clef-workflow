package io.arkitik.clef.workflow.api.adapter.element

import io.arkitik.radix.adapter.shared.StoreImpl
import io.arkitik.clef.workflow.api.adapter.element.creator.ElementIdentityCreatorImpl
import io.arkitik.clef.workflow.api.adapter.element.query.ElementStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.element.repository.ElementRepository
import io.arkitik.clef.workflow.api.adapter.element.updater.ElementIdentityUpdaterImpl
import io.arkitik.clef.workflow.api.entity.element.Element
import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.store.element.ElementStore
import io.arkitik.clef.workflow.api.store.element.creator.ElementIdentityCreator
import io.arkitik.clef.workflow.api.store.element.query.ElementStoreQuery
import io.arkitik.clef.workflow.api.store.element.updater.ElementIdentityUpdater
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class ElementStoreImpl(
    elementRepository: ElementRepository,
) : StoreImpl<String, ElementIdentity, Element>(elementRepository),
    ElementStore {
    override fun ElementIdentity.map(): Element = this as Element

    override val storeQuery: ElementStoreQuery = ElementStoreQueryImpl(elementRepository)

    override fun identityCreator(): ElementIdentityCreator = ElementIdentityCreatorImpl()

    override fun ElementIdentity.identityUpdater(): ElementIdentityUpdater = ElementIdentityUpdaterImpl(map())
}