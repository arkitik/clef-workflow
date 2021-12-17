package io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow

import io.arkitik.radix.develop.usecase.model.UseCaseResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.WorkflowStructure

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class FullWorkflowStructure(
    val workflows: List<WorkflowStructure>,
) : UseCaseResponse