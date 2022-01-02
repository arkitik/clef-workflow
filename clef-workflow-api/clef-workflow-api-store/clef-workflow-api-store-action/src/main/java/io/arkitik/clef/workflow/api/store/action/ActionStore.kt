package io.arkitik.clef.workflow.api.store.action

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.store.action.creator.ActionCreator
import io.arkitik.clef.workflow.api.store.action.query.ActionStoreQuery
import io.arkitik.clef.workflow.api.store.action.updater.ActionUpdater
import io.arkitik.radix.develop.store.Store

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionStore : Store<String, ActionIdentity> {
    override val storeQuery: ActionStoreQuery

    override fun identityCreator(): ActionCreator

    override fun ActionIdentity.identityUpdater(): ActionUpdater
}
