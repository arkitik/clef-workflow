package io.arkitik.clef.workflow.api.store.action

import io.arkitik.clef.workflow.api.domain.action.ActionParameterIdentity
import io.arkitik.clef.workflow.api.store.action.creator.ActionParameterCreator
import io.arkitik.clef.workflow.api.store.action.query.ActionParameterStoreQuery
import io.arkitik.clef.workflow.api.store.action.updater.ActionParameterUpdater
import io.arkitik.radix.develop.store.Store

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionParameterStore : Store<String, ActionParameterIdentity> {
    override val storeQuery: ActionParameterStoreQuery

    override fun identityCreator(): ActionParameterCreator

    override fun ActionParameterIdentity.identityUpdater(): ActionParameterUpdater
}
