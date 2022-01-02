package io.arkitik.clef.workflow.api.adapter.element

import io.arkitik.radix.adapter.shared.StoreImpl
import io.arkitik.clef.workflow.api.adapter.element.creator.ElementFlowIdentityCreatorImpl
import io.arkitik.clef.workflow.api.adapter.element.query.ElementFlowStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.element.repository.ElementFlowRepository
import io.arkitik.clef.workflow.api.entity.element.ElementFlow
import io.arkitik.clef.workflow.api.domain.element.ElementFlowIdentity
import io.arkitik.clef.workflow.api.store.element.ElementFlowStore
import io.arkitik.clef.workflow.api.store.element.creator.ElementFlowIdentityCreator
import io.arkitik.clef.workflow.api.store.element.query.ElementFlowStoreQuery
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class ElementFlowStoreImpl(
    elementFlowRepository: ElementFlowRepository,
) : StoreImpl<String, ElementFlowIdentity, ElementFlow>(elementFlowRepository), ElementFlowStore {
    override fun ElementFlowIdentity.map(): ElementFlow = this as ElementFlow

    override val storeQuery: ElementFlowStoreQuery = ElementFlowStoreQueryImpl(elementFlowRepository)

    override fun identityCreator(): ElementFlowIdentityCreator = ElementFlowIdentityCreatorImpl()

}
