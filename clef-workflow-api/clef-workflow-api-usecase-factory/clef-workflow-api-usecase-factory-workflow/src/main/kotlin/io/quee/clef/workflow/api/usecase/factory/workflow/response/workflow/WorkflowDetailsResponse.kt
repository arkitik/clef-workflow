package io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow

import io.quee.api.develop.usecase.model.UseCaseResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class WorkflowDetailsResponse(
        val workflowUuid: String,
        val workflowKey: String,
        val workflowName: String,
        val workflowDescription: String,
        val initialStage: ViewIdentify?,
        val stages: List<ViewIdentify>
) : UseCaseResponse