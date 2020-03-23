package io.quee.clef.workflow.api.controller.action.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.action.ActionContract
import io.quee.clef.workflow.api.contract.action.dto.CreateTaskActionRequestDto
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RequestMapping("task-actions")
interface ActionApiContract : ActionContract {
    @PostMapping
    override fun @receiver:RequestBody CreateTaskActionRequestDto.create(): ContractResponse<ViewIdentify>

    @GetMapping("{key}/{uuid}")
    override fun details(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ContractResponse<TaskActionDetails>

    @PostMapping("{key}/{uuid}/enable")
    override fun enable(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ContractResponse<SharedResponse>

    @PostMapping("{key}/{uuid}/disable")
    override fun disable(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ContractResponse<SharedResponse>

    @DeleteMapping("{key}/{uuid}/delete")
    override fun delete(@PathVariable("key") key: String, @PathVariable("uuid") uuid: String): ContractResponse<SharedResponse>
}