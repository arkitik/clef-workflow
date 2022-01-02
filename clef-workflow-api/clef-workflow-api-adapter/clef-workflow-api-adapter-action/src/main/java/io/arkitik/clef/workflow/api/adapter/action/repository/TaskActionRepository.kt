package io.arkitik.clef.workflow.api.adapter.action.repository

import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.radix.adapter.shared.repository.RadixRepository
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Repository
interface TaskActionRepository : RadixRepository<String, Action> {
    fun findByActionKey(actionKey: String): Action?
    fun existsByActionKey(actionKey: String): Boolean

    fun findAllBySourceTask(sourceTask: Task): List<Action>
}
