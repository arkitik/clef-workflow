package io.quee.clef.workflow.api.adapter.shared.query

import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.PageData
import io.quee.api.develop.store.StoreQuery
import io.quee.clef.workflow.api.adapter.shared.repository.MainRepository
import io.quee.clef.workflow.api.adapter.shared.toPageData
import org.springframework.data.domain.PageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
open class StoreQueryImpl<I : Identity, E : I>(
        private val mainRepository: MainRepository<E>
) : StoreQuery<I> {
    override fun find(uuid: String): I? = mainRepository.findByUuid(uuid)

    override fun exist(uuid: String): Boolean = mainRepository.existsById(uuid)

    override fun all(): List<I> = mainRepository.findAll()

    override fun all(page: Int, size: Int): PageData<I> = mainRepository.findAll(PageRequest.of(page, size)).toPageData()

    override fun allByUuids(uuids: List<String>): Iterable<I> = mainRepository.findAllById(uuids)
}