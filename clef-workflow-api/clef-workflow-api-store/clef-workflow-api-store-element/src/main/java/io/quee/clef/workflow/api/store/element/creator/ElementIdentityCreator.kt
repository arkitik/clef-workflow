package io.quee.clef.workflow.api.store.element.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementIdentityCreator : StoreIdentityCreator<String, ElementIdentity> {
    fun String.elementKey(): ElementIdentityCreator
    fun WorkflowIdentity.workflow(): ElementIdentityCreator
    fun StageIdentity.currentStage(): ElementIdentityCreator
    fun StageTaskIdentity.currentTask(): ElementIdentityCreator
}