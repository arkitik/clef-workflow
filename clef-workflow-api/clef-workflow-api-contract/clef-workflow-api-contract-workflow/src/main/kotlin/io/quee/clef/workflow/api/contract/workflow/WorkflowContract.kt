package io.quee.clef.workflow.api.contract.workflow

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.Contract
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.workflow.dto.CreateWorkflowRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.FullWorkflowStructure
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface WorkflowContract : Contract {
    fun CreateWorkflowRequestDto.create(): ContractResponse<ViewIdentify>

    fun details(key: String, uuid: String): ContractResponse<WorkflowDetailsResponse>

    fun structure(): ContractResponse<FullWorkflowStructure>

    fun enable(key: String, uuid: String): ContractResponse<SharedResponse>

    fun disable(key: String, uuid: String): ContractResponse<SharedResponse>

    fun delete(key: String, uuid: String): ContractResponse<SharedResponse>
}