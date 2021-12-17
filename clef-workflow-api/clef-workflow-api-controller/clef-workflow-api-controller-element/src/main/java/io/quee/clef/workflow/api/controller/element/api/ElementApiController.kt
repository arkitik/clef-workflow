package io.quee.clef.workflow.api.controller.element.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.controller.element.contract.ElementApiContract
import io.quee.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
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
    private val clefWorkflowEngine: ClefWorkflowEngine,
) : ElementApiContract {
    override fun CreateElementRequest.addElement(): ContractResponse<ViewIdentify> {
        return clefWorkflowEngine.elementContract.run {
            addElement()
        }
    }

    override fun ExecuteActionRequest.executeAction(): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.elementContract.run {
            executeAction()
        }
    }

    override fun elementDetails(elementKey: String): ContractResponse<ElementFullDetailsResponse> {
        return clefWorkflowEngine.elementContract.elementDetails(elementKey)
    }
}