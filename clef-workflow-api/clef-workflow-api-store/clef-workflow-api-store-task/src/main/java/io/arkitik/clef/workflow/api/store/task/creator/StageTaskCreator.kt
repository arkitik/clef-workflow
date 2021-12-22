package io.arkitik.clef.workflow.api.store.task.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageTaskCreator : StoreIdentityCreator<String, StageTaskIdentity> {
    fun String.taskKey(): StageTaskCreator
    fun String.taskName(): StageTaskCreator
}