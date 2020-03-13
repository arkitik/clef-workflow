package io.quee.api.develop.store

import io.quee.api.develop.shared.func.Updater
import io.quee.api.develop.shared.model.Identity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Fri Feb, 2020**
 */
interface StoreIdentityUpdater<I : Identity> : Updater<I> {
    fun delete(): StoreIdentityUpdater<I>
    fun enable(): StoreIdentityUpdater<I>
    fun disable(): StoreIdentityUpdater<I>
}