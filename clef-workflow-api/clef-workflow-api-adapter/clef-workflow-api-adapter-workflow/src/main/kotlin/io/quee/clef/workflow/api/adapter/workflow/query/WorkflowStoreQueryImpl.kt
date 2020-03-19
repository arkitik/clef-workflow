package io.quee.clef.workflow.api.adapter.workflow.query

import io.quee.clef.workflow.api.adapter.entity.Workflow
import io.quee.clef.workflow.api.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.adapter.workflow.repository.WorkflowRepository
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowStoreQueryImpl(
        private val workflowRepository: WorkflowRepository
) : StoreQueryImpl<WorkflowIdentity, Workflow>(workflowRepository), WorkflowStoreQuery {
    override fun findByKeyAndUuid(workflowKey: String, workflowUuid: String): WorkflowIdentity? =
            workflowRepository.findByWorkflowKeyAndUuid(workflowKey, workflowUuid)

    override fun existsByKeyAndUuid(workflowKey: String, workflowUuid: String): Boolean =
            workflowRepository.existsByWorkflowKeyAndUuid(workflowKey, workflowUuid)

    override fun existByKey(workflowKey: String): Boolean =
            workflowRepository.existsByWorkflowKey(workflowKey)
}