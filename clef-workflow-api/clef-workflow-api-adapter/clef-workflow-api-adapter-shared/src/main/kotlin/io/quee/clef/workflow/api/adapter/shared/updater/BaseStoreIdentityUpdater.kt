package io.quee.clef.workflow.api.adapter.shared.updater

import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.store.StoreIdentityUpdater
import io.quee.clef.workflow.api.adapter.shared.entity.BaseIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
abstract class BaseStoreIdentityUpdater<I : Identity> : StoreIdentityUpdater<I> {
    abstract fun entity(): BaseIdentity

    override fun enable(): StoreIdentityUpdater<I> {
        entity().identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun disable(): StoreIdentityUpdater<I> {
        entity().identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun delete(): StoreIdentityUpdater<I> {
        entity().identityStatus = IdentityStatus.DELETED
        return this
    }
}