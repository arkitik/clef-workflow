package io.quee.clef.workflow.api.contract.workflow.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class CreateWorkflowRequestDto(
        @JsonProperty("workflowKey") override val workflowKey: String,
        @JsonProperty("workflowName") override val workflowName: String,
        @JsonProperty("workflowDescription") override val workflowDescription: String
) : CreateWorkflowRequest