package io.quee.clef.workflow.api.adapter.element.query

import io.quee.clef.workflow.api.adapter.element.repository.ElementFlowRepository
import io.quee.clef.workflow.api.adapter.entity.element.ElementFlow
import io.quee.clef.workflow.api.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.quee.clef.workflow.api.store.element.query.ElementFlowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementFlowStoreQueryImpl(
        elementFlowRepository: ElementFlowRepository
) : StoreQueryImpl<ElementFlowIdentity, ElementFlow>(elementFlowRepository), ElementFlowStoreQuery