package io.quee.clef.workflow.api.store.element.creator

import io.quee.api.develop.store.StoreIdentityCreator
import io.quee.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementFlowIdentityCreator : StoreIdentityCreator<ElementFlowIdentity> {
    fun StageTaskIdentity.fromTask(): ElementFlowIdentityCreator
    fun StageTaskIdentity.toTask(): ElementFlowIdentityCreator
    fun TaskActionIdentity.action(): ElementFlowIdentityCreator
}