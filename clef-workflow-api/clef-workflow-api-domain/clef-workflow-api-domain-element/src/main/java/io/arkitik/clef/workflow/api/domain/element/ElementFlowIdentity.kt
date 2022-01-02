package io.arkitik.clef.workflow.api.domain.element

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.radix.develop.identity.Identity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementFlowIdentity : Identity<String> {
    val element: ElementIdentity
    val fromWorkflow: WorkflowIdentity
    val toWorkflow: WorkflowIdentity
    val fromStage: StageIdentity
    val toStage: StageIdentity
    val fromTask: TaskIdentity
    val toTask: TaskIdentity
    val action: ActionIdentity
}
