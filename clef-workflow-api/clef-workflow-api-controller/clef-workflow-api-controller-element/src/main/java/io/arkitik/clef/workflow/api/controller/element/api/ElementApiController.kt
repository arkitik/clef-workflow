package io.arkitik.clef.workflow.api.controller.element.api

import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.clef.workflow.api.controller.element.contract.ElementApiContract
import io.arkitik.clef.workflow.api.sdk.element.dto.CreateElementDto
import io.arkitik.clef.workflow.api.sdk.element.dto.ExecuteActionDto
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RestController
class ElementApiController(
    clefWorkflowEngine: ClefWorkflowEngine,
) : ElementApiContract {
    private val elementSdk = clefWorkflowEngine.elementSdk
    override fun addElement(request: CreateElementDto) =
        elementSdk.createElement.runOperation(request)

    override fun executeAction(request: ExecuteActionDto) =
        elementSdk.executeAction.runOperation(request)

    override fun elementDetails(elementKey: String) =
        elementSdk.elementDetails.runOperation(elementKey)
}