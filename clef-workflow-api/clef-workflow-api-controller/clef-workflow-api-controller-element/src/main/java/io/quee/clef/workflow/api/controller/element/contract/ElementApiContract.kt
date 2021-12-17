package io.quee.clef.workflow.api.controller.element.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.element.ElementContract
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RequestMapping("elements")
interface ElementApiContract : ElementContract {
    @PostMapping("/")
    override fun @receiver:RequestBody CreateElementRequest.addElement(): ContractResponse<ViewIdentify>

    @PostMapping("/execute")
    override fun @receiver:RequestBody ExecuteActionRequest.executeAction(): ContractResponse<SharedResponse>

    @GetMapping("/{key}")
    override fun elementDetails(
        @PathVariable("key") elementKey: String,
    ): ContractResponse<ElementFullDetailsResponse>
}