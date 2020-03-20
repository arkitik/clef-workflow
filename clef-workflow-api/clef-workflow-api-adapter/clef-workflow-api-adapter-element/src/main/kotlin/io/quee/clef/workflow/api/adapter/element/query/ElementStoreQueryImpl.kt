package io.quee.clef.workflow.api.adapter.element.query

import io.quee.clef.workflow.api.adapter.element.repository.ElementRepository
import io.quee.clef.workflow.api.adapter.entity.element.Element
import io.quee.clef.workflow.api.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.store.element.query.ElementStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementStoreQueryImpl(private val mainRepository: ElementRepository) : StoreQueryImpl<ElementIdentity, Element>(mainRepository), ElementStoreQuery {
    override fun findByKeyAndUuid(elementKey: String, elementUuid: String): ElementIdentity? =
            mainRepository.findByElementKeyAndUuid(elementKey, elementUuid)

    override fun existByKey(elementKey: String): Boolean =
            mainRepository.existsByElementKey(elementKey)

}