package io.quee.api.develop.store

import io.quee.api.develop.shared.model.Identity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
interface Store<I : Identity> {
    fun I.save(): I
    fun List<I>.save(): Iterable<I>
    val storeQuery: StoreQuery<I>
    fun identityCreator(): StoreIdentityCreator<I>
    fun I.identityUpdater(): StoreIdentityUpdater<I>
}