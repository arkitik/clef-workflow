package io.arkitik.clef.workflow.api.controller.element.contract

import io.arkitik.clef.workflow.api.sdk.element.dto.CreateElementDto
import io.arkitik.clef.workflow.api.sdk.element.dto.ElementFullDetailsDto
import io.arkitik.clef.workflow.api.sdk.element.dto.ExecuteActionDto
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RequestMapping("elements")
interface ElementApiContract {
    @PostMapping("/")
    fun addElement(@RequestBody request: CreateElementDto): SdkResponse<KeyUuidDto>

    @PostMapping("/execute")
    fun executeAction(@RequestBody request: ExecuteActionDto): SdkResponse<CodeMessageDto>

    @GetMapping("/{key}")
    fun elementDetails(
        @PathVariable("key") elementKey: String,
    ): SdkResponse<ElementFullDetailsDto>
}