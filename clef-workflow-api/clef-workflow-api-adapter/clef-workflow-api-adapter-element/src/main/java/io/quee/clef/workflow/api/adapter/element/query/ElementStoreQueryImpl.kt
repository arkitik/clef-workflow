package io.quee.clef.workflow.api.adapter.element.query

import io.arkitik.radix.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.adapter.element.repository.ElementRepository
import io.quee.clef.workflow.api.entity.element.Element
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.store.element.query.ElementStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementStoreQueryImpl(
    private val mainRepository: ElementRepository,
) : StoreQueryImpl<String, ElementIdentity, Element>(mainRepository), ElementStoreQuery {
    override fun findByKey(elementKey: String): ElementIdentity? =
        mainRepository.findByElementKey(elementKey)

    override fun existByKey(elementKey: String): Boolean =
        mainRepository.existsByElementKey(elementKey)

}