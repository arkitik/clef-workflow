package io.quee.clef.workflow.api.adapter.action.query

import io.quee.clef.workflow.api.adapter.action.repository.TaskActionRepository
import io.quee.clef.workflow.api.adapter.entity.workflow.TaskAction
import io.quee.clef.workflow.api.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.store.action.query.TaskActionStoreQuery
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Service
class TaskActionStoreQueryImpl(
        private val taskActionRepository: TaskActionRepository
) : StoreQueryImpl<TaskActionIdentity, TaskAction>(taskActionRepository), TaskActionStoreQuery {
    override fun findByKeyAndUuid(actionKey: String, actionUuid: String): TaskActionIdentity? =
            taskActionRepository.findByActionKeyAndUuid(actionKey, actionUuid)

    override fun existByKey(actionKey: String): Boolean =
            taskActionRepository.existsByActionKey(actionKey)
}