package io.quee.clef.workflow.api.controller.action.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.action.ActionContract
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest
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
    override fun @receiver:RequestBody CreateTaskActionRequest.create(): ContractResponse<ViewIdentify>

    @GetMapping("{key}")
    override fun details(
        @PathVariable("key") key: String,
    ): ContractResponse<TaskActionDetails>

    @PostMapping("{key}/enable")
    override fun enable(
        @PathVariable("key") key: String,
    ): ContractResponse<SharedResponse>

    @PostMapping("{key}/disable")
    override fun disable(
        @PathVariable("key") key: String,
    ): ContractResponse<SharedResponse>

    @DeleteMapping("{key}/delete")
    override fun delete(
        @PathVariable("key") key: String,
    ): ContractResponse<SharedResponse>
}