package io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow

import io.arkitik.radix.develop.usecase.model.UseCaseResponse
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.WorkflowStructure

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class FullWorkflowStructure(
    val workflows: List<WorkflowStructure>,
) : UseCaseResponse