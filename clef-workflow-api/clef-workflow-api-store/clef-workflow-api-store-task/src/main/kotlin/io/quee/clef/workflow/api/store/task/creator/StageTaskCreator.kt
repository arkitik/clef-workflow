package io.quee.clef.workflow.api.store.task.creator

import io.quee.api.develop.store.StoreIdentityCreator
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageTaskCreator : StoreIdentityCreator<StageTaskIdentity> {
    fun String.taskKey(): StageTaskCreator
    fun String.taskName(): StageTaskCreator
}