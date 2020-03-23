package io.quee.clef.workflow.api.contract.element

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.element.dto.CreateElementRequestDto
import io.quee.clef.workflow.api.contract.element.dto.ExecuteActionRequestDto
import io.quee.clef.workflow.api.contract.shared.Contract
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **23**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementContract : Contract {
    fun CreateElementRequestDto.addElement(): ContractResponse<ViewIdentify>
    fun ExecuteActionRequestDto.executeAction(): ContractResponse<SharedResponse>
    fun elementDetails(elementUuid: String, elementKey: String): ContractResponse<ElementFullDetailsResponse>
}