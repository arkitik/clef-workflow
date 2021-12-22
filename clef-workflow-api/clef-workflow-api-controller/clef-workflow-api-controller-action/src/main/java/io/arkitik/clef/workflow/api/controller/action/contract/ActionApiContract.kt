package io.arkitik.clef.workflow.api.controller.action.contract

import io.arkitik.clef.workflow.api.sdk.action.dto.CreateTaskActionDto
import io.arkitik.clef.workflow.api.sdk.action.dto.TaskActionDto
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RequestMapping("task-actions")
interface ActionApiContract {
    @PostMapping
    fun create(@RequestBody request: CreateTaskActionDto): SdkResponse<KeyUuidDto>

    @GetMapping("{key}")
    fun details(
        @PathVariable("key") key: String,
    ): SdkResponse<TaskActionDto>

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