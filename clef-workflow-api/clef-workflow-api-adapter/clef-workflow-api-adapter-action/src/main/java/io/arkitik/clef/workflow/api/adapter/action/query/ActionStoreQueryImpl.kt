package io.arkitik.clef.workflow.api.adapter.action.query

import io.arkitik.clef.workflow.api.adapter.action.repository.TaskActionRepository
import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.action.query.ActionStoreQuery
import io.arkitik.radix.adapter.shared.query.StoreQueryImpl
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class ActionStoreQueryImpl(
    private val taskActionRepository: TaskActionRepository,
) : StoreQueryImpl<String, ActionIdentity, Action>(taskActionRepository), ActionStoreQuery {
    override fun findByKey(actionKey: String): ActionIdentity? =
        taskActionRepository.findByActionKey(actionKey)

    override fun existByKey(actionKey: String): Boolean =
        taskActionRepository.existsByActionKey(actionKey)

    override fun findAllByTask(task: TaskIdentity) =
        taskActionRepository.findAllBySourceTask(task as Task)
}
