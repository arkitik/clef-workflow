package io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture

import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class WorkflowStructure(
    val workflowUuid: String,
    val workflowKey: String,
    val workflowName: String,
    val status: IdentityStatus,
    val workflowDescription: String,
    val initialStage: StageStructure?,
    val stages: List<StageStructure>,
)