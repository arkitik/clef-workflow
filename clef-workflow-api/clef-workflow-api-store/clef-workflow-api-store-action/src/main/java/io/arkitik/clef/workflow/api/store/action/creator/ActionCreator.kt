package io.arkitik.clef.workflow.api.store.action.creator

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionCreator : StoreIdentityCreator<String, ActionIdentity> {
    fun String.actionKey(): ActionCreator
    fun String.actionName(): ActionCreator
    fun String.actionDescription(): ActionCreator
    fun TaskIdentity.destinationTask(): ActionCreator
    fun TaskIdentity.sourceTask(): ActionCreator
}
