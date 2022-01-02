package io.arkitik.clef.workflow.api.adapter.element.query

import io.arkitik.radix.adapter.shared.query.StoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.element.repository.ElementFlowRepository
import io.arkitik.clef.workflow.api.entity.element.ElementFlow
import io.arkitik.clef.workflow.api.domain.element.ElementFlowIdentity
import io.arkitik.clef.workflow.api.store.element.query.ElementFlowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementFlowStoreQueryImpl(
    elementFlowRepository: ElementFlowRepository,
) : StoreQueryImpl<String, ElementFlowIdentity, ElementFlow>(elementFlowRepository), ElementFlowStoreQuery
