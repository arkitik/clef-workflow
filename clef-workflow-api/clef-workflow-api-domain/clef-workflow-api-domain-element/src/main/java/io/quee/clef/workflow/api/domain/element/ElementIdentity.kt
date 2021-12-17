package io.quee.clef.workflow.api.domain.element

import io.quee.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.quee.clef.workflow.api.domain.shared.StatusAwareIdentity
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementIdentity : StatusAwareIdentity<String> {
    val elementKey: String
    val workflow: WorkflowIdentity
    val currentStage: StageIdentity
    val currentTask: StageTaskIdentity
    val flows: List<ElementFlowIdentity>
}