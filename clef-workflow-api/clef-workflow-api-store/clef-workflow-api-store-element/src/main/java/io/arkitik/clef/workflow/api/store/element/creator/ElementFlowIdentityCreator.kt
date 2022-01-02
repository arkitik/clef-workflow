package io.arkitik.clef.workflow.api.store.element.creator

import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.element.ElementFlowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementFlowIdentityCreator : StoreIdentityCreator<String, ElementFlowIdentity> {
    fun ElementIdentity.element(): ElementFlowIdentityCreator
    fun WorkflowIdentity.fromWorkflow(): ElementFlowIdentityCreator
    fun WorkflowIdentity.toWorkflow(): ElementFlowIdentityCreator
    fun StageIdentity.fromStage(): ElementFlowIdentityCreator
    fun StageIdentity.toStage(): ElementFlowIdentityCreator
    fun TaskIdentity.fromTask(): ElementFlowIdentityCreator
    fun TaskIdentity.toTask(): ElementFlowIdentityCreator
    fun ActionIdentity.action(): ElementFlowIdentityCreator
}
