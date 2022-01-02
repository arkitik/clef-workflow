package io.arkitik.clef.workflow.api.adapter.workflow.repository

import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.radix.adapter.shared.repository.RadixRepository
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Repository
interface WorkflowRepository : RadixRepository<String, Workflow> {
    fun findByWorkflowKey(workflowKey: String): Workflow?
    fun existsByWorkflowKeyAndUuid(workflowKey: String, uuid: String): Boolean
    fun existsByWorkflowKey(workflowKey: String): Boolean
}
