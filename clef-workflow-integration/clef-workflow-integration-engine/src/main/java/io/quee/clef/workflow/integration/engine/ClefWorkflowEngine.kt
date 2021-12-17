package io.quee.clef.workflow.integration.engine

import io.quee.clef.workflow.api.contract.action.ActionContract
import io.quee.clef.workflow.api.contract.element.ElementContract
import io.quee.clef.workflow.api.contract.stage.StageContract
import io.quee.clef.workflow.api.contract.task.StageTaskContract
import io.quee.clef.workflow.api.contract.workflow.WorkflowContract

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **23**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ClefWorkflowEngine {
    val actionContract: ActionContract
    val elementContract: ElementContract
    val stageContract: StageContract
    val stageTaskContract: StageTaskContract
    val workflowContract: WorkflowContract
}