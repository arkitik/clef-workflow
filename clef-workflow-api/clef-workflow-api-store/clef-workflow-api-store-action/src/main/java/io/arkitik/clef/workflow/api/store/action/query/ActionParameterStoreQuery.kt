package io.arkitik.clef.workflow.api.store.action.query

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.action.ActionParameterIdentity
import io.arkitik.radix.develop.store.query.StoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionParameterStoreQuery : StoreQuery<String, ActionParameterIdentity> {
    fun findAllByAction(
        action: ActionIdentity,
    ): List<ActionParameterIdentity>
}
