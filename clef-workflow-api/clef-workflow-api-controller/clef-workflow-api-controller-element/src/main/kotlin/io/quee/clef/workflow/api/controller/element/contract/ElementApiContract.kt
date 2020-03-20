package io.quee.clef.workflow.api.controller.element.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.controller.element.dto.CreateElementRequestDto
import io.quee.clef.workflow.api.controller.element.dto.ExecuteActionRequestDto
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse
import org.springframework.http.ResponseEntity
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
interface ElementApiContract {
    @PostMapping("/")
    fun @receiver:RequestBody CreateElementRequestDto.addElement(): ResponseEntity<ViewIdentify>

    @PostMapping("/execute")
    fun @receiver:RequestBody ExecuteActionRequestDto.executeAction(): ResponseEntity<SharedResponse>

    @GetMapping("/")
    fun elementDetails(elementUuid: String, elementKey: String): ResponseEntity<ElementFullDetailsResponse>
}