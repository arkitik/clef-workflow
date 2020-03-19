package io.quee.clef.workflow.api.adapter.shared.creator

import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.store.StoreIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
abstract class BaseStoreIdentityCreator<I : Identity> : StoreIdentityCreator<I> {
    protected var identityStatus: IdentityStatus = IdentityStatus.ENABLED
    override fun enable(): StoreIdentityCreator<I> {
        identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun disable(): StoreIdentityCreator<I> {
        identityStatus = IdentityStatus.DISABLED
        return this
    }
}