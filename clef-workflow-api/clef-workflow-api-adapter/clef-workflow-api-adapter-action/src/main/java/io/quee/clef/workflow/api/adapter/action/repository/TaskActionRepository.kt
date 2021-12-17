package io.quee.clef.workflow.api.adapter.action.repository

import io.arkitik.radix.adapter.shared.repository.RadixRepository
import io.quee.clef.workflow.api.entity.workflow.TaskAction
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Repository
interface TaskActionRepository : RadixRepository<String, TaskAction> {
    fun findByActionKey(actionKey: String): TaskAction?

    fun existsByActionKey(actionKey: String): Boolean
}