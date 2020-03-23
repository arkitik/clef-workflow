package io.quee.clef.workflow.api.controller.element.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.element.ElementContract
import io.quee.clef.workflow.api.contract.element.dto.CreateElementRequestDto
import io.quee.clef.workflow.api.contract.element.dto.ExecuteActionRequestDto
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RequestMapping("elements")
interface ElementApiContract : ElementContract {
    @PostMapping("/")
    override fun @receiver:RequestBody CreateElementRequestDto.addElement(): ContractResponse<ViewIdentify>

    @PostMapping("/execute")
    override fun @receiver:RequestBody ExecuteActionRequestDto.executeAction(): ContractResponse<SharedResponse>

    @GetMapping("/")
    override fun elementDetails(elementUuid: String, elementKey: String): ContractResponse<ElementFullDetailsResponse>
}