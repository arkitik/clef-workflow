package io.arkitik.clef.workflow.api.store.action.query

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.radix.develop.store.query.StoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionStoreQuery : StoreQuery<String, ActionIdentity> {
    fun findByKey(
        actionKey: String,
    ): ActionIdentity?

    fun existByKey(actionKey: String): Boolean

    fun findAllByTask(
        task: TaskIdentity,
    ): List<ActionIdentity>
}
