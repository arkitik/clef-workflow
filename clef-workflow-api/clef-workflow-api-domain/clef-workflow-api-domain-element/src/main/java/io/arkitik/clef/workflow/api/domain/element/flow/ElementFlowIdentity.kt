package io.arkitik.clef.workflow.api.domain.element.flow

import io.arkitik.clef.workflow.api.domain.shared.StatusAwareIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementFlowIdentity : StatusAwareIdentity<String> {
    val fromWorkflow: WorkflowIdentity
    val toWorkflow: WorkflowIdentity
    val fromStage: StageIdentity
    val toStage: StageIdentity
    val fromTask: StageTaskIdentity
    val toTask: StageTaskIdentity
    val action: TaskActionIdentity
}