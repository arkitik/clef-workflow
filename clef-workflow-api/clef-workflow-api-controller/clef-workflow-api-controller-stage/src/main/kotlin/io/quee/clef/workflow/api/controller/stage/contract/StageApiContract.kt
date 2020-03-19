package io.quee.clef.workflow.api.controller.stage.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.controller.stage.dto.CreateStageRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RequestMapping("workflow-stages")
interface StageApiContract {
    @PostMapping
    fun @receiver:RequestBody CreateStageRequestDto.create(): ResponseEntity<ViewIdentify>

    @GetMapping("{key}/{uuid}")
    fun details(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ResponseEntity<StageDetailsResponse>

    @PostMapping("{key}/{uuid}/enable")
    fun enable(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ResponseEntity<SharedResponse>

    @PostMapping("{key}/{uuid}/disable")
    fun disable(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ResponseEntity<SharedResponse>

    @DeleteMapping("{key}/{uuid}/delete")
    fun delete(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ResponseEntity<SharedResponse>
}