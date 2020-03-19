package io.quee.clef.workflow.api.usecase.factory.domain.request

import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface AddStageToWorkflowRequest : UseCaseRequest {
    val workflow: WorkflowIdentity
    val stage: StageIdentity
    val initialStage: Boolean

    companion object {
        fun instance(workflow: WorkflowIdentity, stage: StageIdentity, initialStage: Boolean): AddStageToWorkflowRequest {
            return object : AddStageToWorkflowRequest {
                override val workflow: WorkflowIdentity = workflow
                override val stage: StageIdentity = stage
                override val initialStage: Boolean = initialStage
            }
        }
    }
}