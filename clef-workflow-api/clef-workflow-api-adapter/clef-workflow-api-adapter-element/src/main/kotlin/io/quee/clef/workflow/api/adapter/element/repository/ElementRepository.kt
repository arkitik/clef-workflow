package io.quee.clef.workflow.api.adapter.element.repository

import io.quee.clef.workflow.api.adapter.entity.element.Element
import io.quee.clef.workflow.api.adapter.shared.repository.MainRepository
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Repository
interface ElementRepository : MainRepository<Element> {
    fun findByElementKeyAndUuid(elementKey: String, uuid: String): Element?
    fun existsByElementKey(elementKey: String): Boolean
}