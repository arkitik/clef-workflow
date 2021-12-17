package io.quee.clef.workflow.api.adapter.element.repository

import io.arkitik.radix.adapter.shared.repository.RadixRepository
import io.quee.clef.workflow.api.entity.element.Element
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Repository
interface ElementRepository : RadixRepository<String, Element> {
    fun findByElementKey(elementKey: String): Element?
    fun existsByElementKey(elementKey: String): Boolean
}