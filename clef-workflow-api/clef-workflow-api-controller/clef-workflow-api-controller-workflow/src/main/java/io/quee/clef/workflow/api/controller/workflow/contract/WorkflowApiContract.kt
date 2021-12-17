package io.quee.clef.workflow.api.controller.workflow.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.workflow.WorkflowContract
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.FullWorkflowStructure
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RequestMapping("workflows")
interface WorkflowApiContract : WorkflowContract {
    @PostMapping
    override fun @receiver:RequestBody CreateWorkflowRequest.create(): ContractResponse<ViewIdentify>

    @GetMapping("{key}")
    override fun details(
        @PathVariable("key") key: String,
    ): ContractResponse<WorkflowDetailsResponse>

    @GetMapping("/")
    override fun structure(): ContractResponse<FullWorkflowStructure>

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