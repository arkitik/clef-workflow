package io.quee.clef.workflow.api.adapter.workflow.repository

import io.quee.clef.workflow.api.adapter.entity.Workflow
import io.quee.clef.workflow.api.adapter.shared.repository.MainRepository
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Repository
interface WorkflowRepository : MainRepository<Workflow> {
    fun findByWorkflowKeyAndUuid(workflowKey: String, uuid: String): Workflow?
    fun existsByWorkflowKeyAndUuid(workflowKey: String, uuid: String): Boolean
    fun existsByWorkflowKey(workflowKey: String): Boolean
}