package io.arkitik.clef.workflow.api.store.task.creator

import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskCreator : StoreIdentityCreator<String, TaskIdentity> {
    fun String.taskKey(): TaskCreator
    fun String.taskName(): TaskCreator
    fun StageIdentity.stage(): TaskCreator
}
