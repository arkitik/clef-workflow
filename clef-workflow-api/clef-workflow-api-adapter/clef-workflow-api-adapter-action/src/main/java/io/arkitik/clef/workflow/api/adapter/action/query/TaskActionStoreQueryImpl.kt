package io.arkitik.clef.workflow.api.adapter.action.query

import io.arkitik.radix.adapter.shared.query.StoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.action.repository.TaskActionRepository
import io.arkitik.clef.workflow.api.entity.workflow.TaskAction
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.store.action.query.TaskActionStoreQuery
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class TaskActionStoreQueryImpl(
    private val taskActionRepository: TaskActionRepository,
) : StoreQueryImpl<String, TaskActionIdentity, TaskAction>(taskActionRepository), TaskActionStoreQuery {
    override fun findByKey(actionKey: String): TaskActionIdentity? =
        taskActionRepository.findByActionKey(actionKey)

    override fun existByKey(actionKey: String): Boolean =
        taskActionRepository.existsByActionKey(actionKey)
}