package io.arkitik.clef.workflow.api.store.element.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementFlowIdentityCreator : StoreIdentityCreator<String, ElementFlowIdentity> {
    fun WorkflowIdentity.fromWorkflow(): ElementFlowIdentityCreator
    fun WorkflowIdentity.toWorkflow(): ElementFlowIdentityCreator
    fun StageIdentity.fromStage(): ElementFlowIdentityCreator
    fun StageIdentity.toStage(): ElementFlowIdentityCreator
    fun StageTaskIdentity.fromTask(): ElementFlowIdentityCreator
    fun StageTaskIdentity.toTask(): ElementFlowIdentityCreator
    fun TaskActionIdentity.action(): ElementFlowIdentityCreator
}