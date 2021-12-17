package io.quee.clef.workflow.api.controller.stage.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.stage.StageContract
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse
import org.springframework.web.bind.annotation.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RequestMapping("workflow-stages")
interface StageApiContract : StageContract {
    @PostMapping
    override fun @receiver:RequestBody CreateStageRequest.create(): ContractResponse<ViewIdentify>

    @GetMapping("{key}")
    override fun details(
        @PathVariable("key") key: String,
    ): ContractResponse<StageDetailsResponse>

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