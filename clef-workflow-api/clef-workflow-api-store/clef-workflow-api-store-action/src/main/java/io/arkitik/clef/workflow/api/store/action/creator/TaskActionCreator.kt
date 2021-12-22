package io.arkitik.clef.workflow.api.store.action.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionParameter
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskActionCreator : StoreIdentityCreator<String, TaskActionIdentity> {
    fun String.actionKey(): TaskActionCreator
    fun String.actionName(): TaskActionCreator
    fun String.actionDescription(): TaskActionCreator
    fun StageTaskIdentity.destinationTask(): TaskActionCreator
    fun TaskActionParameter.addParam(): TaskActionCreator
}