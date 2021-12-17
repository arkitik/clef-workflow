package io.quee.clef.workflow.api.store.workflow.query

import io.arkitik.radix.develop.store.query.StoreQuery
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
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
    fun findByStage(stageIdentity: StageIdentity): WorkflowIdentity?
}