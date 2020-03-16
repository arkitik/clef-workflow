package io.quee.clef.workflow.api.store.action.creator

import io.quee.api.develop.store.StoreIdentityCreator
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface TaskActionCreator : StoreIdentityCreator<TaskActionIdentity> {
    fun String.actionKey(): TaskActionCreator
    fun String.actionName(): TaskActionCreator
    fun String.actionDescription(): TaskActionCreator
    fun StageTaskIdentity.destinationTask(): TaskActionCreator
}