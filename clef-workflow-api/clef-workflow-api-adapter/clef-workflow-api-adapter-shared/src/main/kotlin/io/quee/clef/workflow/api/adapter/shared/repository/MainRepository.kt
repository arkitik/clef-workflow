package io.quee.clef.workflow.api.adapter.shared.repository

import io.quee.api.develop.shared.model.Identity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@NoRepositoryBean
interface MainRepository<I : Identity> : JpaRepository<I, String> {
    fun <S : I> save(entities: List<S>): MutableList<S> {
        return saveAll(entities)
    }

    fun findByUuid(uuid: String): I?
}