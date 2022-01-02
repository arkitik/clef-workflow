package io.arkitik.clef.workflow.api.store.workflow.query

import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.radix.develop.store.query.StoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface WorkflowStoreQuery : StoreQuery<String, WorkflowIdentity> {
    fun findByKey(
        workflowKey: String,
    ): WorkflowIdentity?

    fun existsByKeyAndUuid(
        workflowKey: String,
        workflowUuid: String,
    ): Boolean

    fun existByKey(workflowKey: String): Boolean
}
