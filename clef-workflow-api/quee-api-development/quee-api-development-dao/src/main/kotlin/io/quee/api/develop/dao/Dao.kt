package io.quee.api.develop.dao

import io.quee.api.develop.shared.func.Creator
import io.quee.api.develop.shared.func.Updater
import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.Location
import io.quee.api.develop.shared.model.PageData
import io.quee.api.develop.shared.model.TranslatedValue
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
interface Dao<I : Identity> {
    fun save(item: I): I
    fun save(item: List<I>)
    fun find(uuid: String): Optional<I>
    fun all(): List<I>
    fun all(page: Int, size: Int): PageData<I>
    fun allByIds(uuids: List<String>): List<I>
    fun exist(uuid: String): Boolean
    fun identityCreator(): IdentityCreator<I>
    fun identityUpdater(identity: I): IdentityUpdater<I>
    fun locationCreator(): LocationCreator
    fun translatedValueCreator(): TranslatedValueCreator
    interface TranslatedValueCreator : Creator<TranslatedValue> {
        fun nameAr(nameAr: String): TranslatedValueCreator
        fun nameEn(nameEn: String): TranslatedValueCreator
    }

    interface LocationCreator {
        fun longitude(longitude: Double): LocationCreator
        fun latitude(latitude: Double): LocationCreator
        fun create(): Location
    }

    interface IdentityCreator<E : Identity> : Creator<E> {
        fun uuid(uuid: String): IdentityCreator<E>
        fun enable(): IdentityCreator<E>
        fun disable(): IdentityCreator<E>
    }

    interface IdentityUpdater<E : Identity> : Updater<E> {
        fun delete(): IdentityUpdater<E>
        fun enable(): IdentityUpdater<E>
        fun disable(): IdentityUpdater<E>
    }
}