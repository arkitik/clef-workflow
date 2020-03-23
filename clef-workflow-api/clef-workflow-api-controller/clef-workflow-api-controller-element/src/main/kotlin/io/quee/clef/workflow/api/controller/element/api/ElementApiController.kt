package io.quee.clef.workflow.api.controller.element.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.element.dto.CreateElementRequestDto
import io.quee.clef.workflow.api.contract.element.dto.ExecuteActionRequestDto
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.controller.element.contract.ElementApiContract
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse
import io.quee.clef.workflow.integration.engine.ClefWorkflowEngine
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class ElementApiController(
        private val clefWorkflowEngine: ClefWorkflowEngine
) : ElementApiContract {
    override fun CreateElementRequestDto.addElement(): ContractResponse<ViewIdentify> {
        return clefWorkflowEngine.elementContract.run {
            addElement()
        }
    }

    override fun ExecuteActionRequestDto.executeAction(): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.elementContract.run {
            executeAction()
        }
    }

    override fun elementDetails(elementUuid: String, elementKey: String): ContractResponse<ElementFullDetailsResponse> {
        return clefWorkflowEngine.elementContract.elementDetails(elementUuid, elementKey)
    }
}