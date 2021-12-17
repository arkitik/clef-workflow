package io.quee.clef.workflow.integration.spring.boot.starter.contract

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.element.ElementContract
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ElementByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementContractImpl(
    private val elementUseCaseFactory: ElementUseCaseFactory,
) : ElementContract {
    override fun CreateElementRequest.addElement(): ContractResponse<ViewIdentify> {
        elementUseCaseFactory.createElementUseCase
            .run {
                return ContractResponse(this@addElement.process())
            }
    }

    override fun ExecuteActionRequest.executeAction(): ContractResponse<SharedResponse> {
        elementUseCaseFactory.executeActionIntoElementUseCase
            .run {
                return ContractResponse(this@executeAction.process())
            }
    }

    override fun elementDetails(elementKey: String): ContractResponse<ElementFullDetailsResponse> {
        elementUseCaseFactory.elementFullDetailsUseCase
            .run {
                return ContractResponse(RequestAdapter(ElementByKeyRequest(elementKey)).process())
            }
    }
}