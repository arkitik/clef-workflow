package io.arkitik.clef.workflow.api.store.action.query

import io.arkitik.radix.develop.store.query.StoreQuery
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskActionStoreQuery : StoreQuery<String, TaskActionIdentity> {
    fun findByKey(
        actionKey: String,
    ): TaskActionIdentity?

    fun existByKey(actionKey: String): Boolean
}