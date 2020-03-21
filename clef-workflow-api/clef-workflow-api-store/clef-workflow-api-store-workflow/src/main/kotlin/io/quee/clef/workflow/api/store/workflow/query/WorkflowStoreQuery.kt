package io.quee.clef.workflow.api.store.workflow.query

import io.quee.api.develop.store.StoreQuery
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface WorkflowStoreQuery : StoreQuery<WorkflowIdentity> {
    fun findByKeyAndUuid(
            workflowKey: String,
            workflowUuid: String
    ): WorkflowIdentity?

    fun existsByKeyAndUuid(
            workflowKey: String,
            workflowUuid: String
    ): Boolean

    fun existByKey(workflowKey: String): Boolean
    fun findByStage(stageIdentity: StageIdentity): WorkflowIdentity?
}