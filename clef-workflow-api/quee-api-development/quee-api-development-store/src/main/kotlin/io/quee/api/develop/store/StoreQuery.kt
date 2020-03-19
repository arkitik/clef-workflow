package io.quee.api.develop.store

import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.PageData

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Fri Feb, 2020**
 */
interface StoreQuery<I : Identity> {
    fun find(uuid: String): I?
    fun exist(uuid: String): Boolean
    fun all(): List<I>
    fun all(page: Int, size: Int): PageData<I>
    fun allByUuids(uuids: List<String>): Iterable<I>
}