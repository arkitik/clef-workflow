package io.arkitik.clef.workflow.api.usecase.factory.domain.request

import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class AddStageToWorkflowRequest(
    val workflow: WorkflowIdentity,
    val stage: StageIdentity,
    val initialStage: Boolean,
) : UseCaseRequest