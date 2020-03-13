package io.quee.api.develop.store

import io.quee.api.develop.shared.func.Creator
import io.quee.api.develop.shared.model.Identity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Fri Feb, 2020**
 */
interface StoreIdentityCreator<I : Identity> : Creator<I> {
    fun enable(): StoreIdentityCreator<I>
    fun disable(): StoreIdentityCreator<I>
}