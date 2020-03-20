package io.quee.clef.workflow.api.adapter.action.repository

import io.quee.clef.workflow.api.adapter.entity.workflow.TaskAction
import io.quee.clef.workflow.api.adapter.shared.repository.MainRepository
import org.springframework.stereotype.Repository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Repository
interface TaskActionRepository : MainRepository<TaskAction> {
    fun findByActionKeyAndUuid(actionKey: String, uuid: String): TaskAction?

    fun existsByActionKey(actionKey: String): Boolean
}