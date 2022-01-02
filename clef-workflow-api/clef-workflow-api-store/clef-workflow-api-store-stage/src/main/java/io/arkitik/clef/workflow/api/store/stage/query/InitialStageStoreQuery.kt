package io.arkitik.clef.workflow.api.store.stage.query

import io.arkitik.clef.workflow.api.domain.stage.InitialStageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.radix.develop.store.query.StoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface InitialStageStoreQuery : StoreQuery<String, InitialStageIdentity> {
    fun existsByWorkflow(workflow: WorkflowIdentity): Boolean
    fun findByWorkflow(workflow: WorkflowIdentity): InitialStageIdentity?
}
