package io.quee.clef.workflow.api.adapter.shared

import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.store.Store
import io.quee.api.develop.store.StoreQuery
import io.quee.clef.workflow.api.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.adapter.shared.repository.MainRepository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
abstract class StoreImpl<I : Identity, E : I>(
        private val mainRepository: MainRepository<E>
) : Store<I> {
    abstract fun I.map(): E
    override fun I.save(): I = mainRepository.save(this.map())

    override fun List<I>.save(): Iterable<I> = mainRepository.save(map {
        it.map()
    })

    override val storeQuery: StoreQuery<I> = StoreQueryImpl(mainRepository)
}