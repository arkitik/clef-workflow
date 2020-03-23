package io.quee.clef.workflow.api.contract.workflow.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class WorkflowRequestDto(
        @JsonProperty("workflowKey") override val workflowKey: String,
        @JsonProperty("workflowUuid") override val workflowUuid: String
) : WorkflowRequest<UseCaseRequest> {
    override val request: UseCaseRequest =
            UseCaseRequest.NOP
}