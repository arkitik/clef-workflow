package io.quee.clef.workflow.api.controller.action.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.controller.action.dto.CreateTaskActionRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RequestMapping("task-actions")
interface ActionApiContract {
    @PostMapping
    fun @receiver:RequestBody CreateTaskActionRequestDto.create(): ResponseEntity<ViewIdentify>

    @GetMapping("{key}/{uuid}")
    fun details(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ResponseEntity<TaskActionDetails>

    @PostMapping("{key}/{uuid}/enable")
    fun enable(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ResponseEntity<SharedResponse>

    @PostMapping("{key}/{uuid}/disable")
    fun disable(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ResponseEntity<SharedResponse>

    @DeleteMapping("{key}/{uuid}/delete")
    fun delete(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ResponseEntity<SharedResponse>
}