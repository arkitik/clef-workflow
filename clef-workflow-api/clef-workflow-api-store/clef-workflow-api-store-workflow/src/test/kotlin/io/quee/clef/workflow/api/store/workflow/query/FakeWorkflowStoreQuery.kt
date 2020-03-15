package io.quee.clef.workflow.api.store.workflow.query

import io.quee.api.develop.shared.model.PageData
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FakeWorkflowStoreQuery(private val list: List<WorkflowIdentity>) : WorkflowStoreQuery {
    override fun findByKeyAndUuid(workflowKey: String, workflowUuid: String): WorkflowIdentity? {
        return list.find {
            it.workflowKey == workflowKey && it.uuid == workflowUuid
        }
    }

    override fun existsByKeyAndUuid(workflowKey: String, workflowUuid: String): Boolean =
            list.find {
                it.workflowKey == workflowKey && it.uuid == workflowUuid
            } != null

    override fun existByKey(workflowKey: String): Boolean = list.find {
        it.workflowKey == workflowKey
    } != null

    override fun find(uuid: String): WorkflowIdentity? = list.find {
        it.uuid == uuid
    }

    override fun exist(uuid: String): Boolean =
            find(uuid) != null

    override fun all(): List<WorkflowIdentity> = list

    override fun all(page: Int, size: Int): PageData<WorkflowIdentity> {
        TODO("Not yet implemented")
    }

    override fun allByUuids(uuids: List<String>): Iterable<WorkflowIdentity> =
            list.filter {
                uuids.contains(it.uuid)
            }
}