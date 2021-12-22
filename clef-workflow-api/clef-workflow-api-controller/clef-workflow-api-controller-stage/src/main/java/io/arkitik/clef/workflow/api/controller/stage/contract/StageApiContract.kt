package io.arkitik.clef.workflow.api.controller.stage.contract

import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.sdk.stage.dto.CreateStageDto
import io.arkitik.clef.workflow.api.sdk.stage.dto.StageDto
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RequestMapping("workflow-stages")
interface StageApiContract {
    @PostMapping
    fun create(@RequestBody request: CreateStageDto): SdkResponse<KeyUuidDto>

    @GetMapping("{key}")
    fun details(
        @PathVariable("key") key: String,
    ): SdkResponse<StageDto>

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