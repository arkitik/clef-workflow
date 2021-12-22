package io.arkitik.clef.workflow.api.controller.workflow.contract

import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.sdk.workflow.dto.CreateWorkflowDto
import io.arkitik.clef.workflow.api.sdk.workflow.dto.FullWorkflowStructureDto
import io.arkitik.clef.workflow.api.sdk.workflow.dto.WorkflowDetailsDto
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RequestMapping("workflows")
interface WorkflowApiContract {
    @PostMapping
    fun create(@RequestBody request: CreateWorkflowDto): SdkResponse<KeyUuidDto>

    @GetMapping("{key}")
    fun details(
        @PathVariable("key") key: String,
    ): SdkResponse<WorkflowDetailsDto>

    @GetMapping("/")
    fun structure(): SdkResponse<FullWorkflowStructureDto>

    @PostMapping("{key}/enable")
    fun enable(
        @PathVariable("key") key: String,
    ): SdkResponse<CodeMessageDto>

    @PostMapping("{key}/disable")
    fun disable(
        @PathVariable("key") key: String,
    ): SdkResponse<CodeMessageDto>

    @DeleteMapping("{key}/delete")
    fun delete(
        @PathVariable("key") key: String,
    ): SdkResponse<CodeMessageDto>
}