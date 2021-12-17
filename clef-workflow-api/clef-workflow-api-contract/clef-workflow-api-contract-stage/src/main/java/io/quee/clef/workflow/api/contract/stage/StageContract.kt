package io.quee.clef.workflow.api.contract.stage

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.Contract
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageContract : Contract {
    fun CreateStageRequest.create(): ContractResponse<ViewIdentify>
    fun details(key: String): ContractResponse<StageDetailsResponse>
    fun enable(key: String): ContractResponse<SharedResponse>
    fun disable(key: String): ContractResponse<SharedResponse>
    fun delete(key: String): ContractResponse<SharedResponse>
}