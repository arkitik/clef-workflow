package io.quee.clef.workflow.integration.spring.boot.starter.contract

import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.element.ElementContract
import io.quee.clef.workflow.api.contract.element.dto.CreateElementRequestDto
import io.quee.clef.workflow.api.contract.element.dto.ElementByUuidAndKeyDto
import io.quee.clef.workflow.api.contract.element.dto.ExecuteActionRequestDto
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.request.ElementByUuidAndKey
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementContractImpl(
        private val elementUseCaseFactory: ElementUseCaseFactory
) : ElementContract {
    override fun CreateElementRequestDto.addElement(): ContractResponse<ViewIdentify> {
        elementUseCaseFactory.createElementUseCase
                .run {
                    return ContractResponse(this@addElement.process())
                }
    }

    override fun ExecuteActionRequestDto.executeAction(): ContractResponse<SharedResponse> {
        elementUseCaseFactory.executeActionIntoElementUseCase
                .run {
                    return ContractResponse(this@executeAction.process())
                }
    }

    override fun elementDetails(elementUuid: String, elementKey: String): ContractResponse<ElementFullDetailsResponse> {
        elementUseCaseFactory.elementFullDetailsUseCase
                .run {
                    return ContractResponse(RequestAdapter<ElementByUuidAndKey>(ElementByUuidAndKeyDto(elementUuid, elementKey)).process())
                }
    }
}