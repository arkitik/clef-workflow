package io.arkitik.clef.workflow.sdk.engine

import io.arkitik.clef.workflow.api.sdk.action.ActionSdk
import io.arkitik.clef.workflow.api.sdk.element.ElementSdk
import io.arkitik.clef.workflow.api.sdk.stage.StageSdk
import io.arkitik.clef.workflow.api.sdk.task.StageTaskSdk
import io.arkitik.clef.workflow.api.sdk.workflow.WorkflowSdk

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **23**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ClefWorkflowEngine {
    val actionSdk: ActionSdk
    val elementSdk: ElementSdk
    val stageSdk: StageSdk
    val stageTaskSdk: StageTaskSdk
    val workflowSdk: WorkflowSdk
}