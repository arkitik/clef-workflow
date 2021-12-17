package io.quee.clef.workflow.api.controller.stage.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.controller.stage.contract.StageApiContract
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse
import io.quee.clef.workflow.integration.engine.ClefWorkflowEngine
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class StageApiController(private val clefWorkflowEngine: ClefWorkflowEngine) : StageApiContract {
    override fun CreateStageRequest.create(): ContractResponse<ViewIdentify> {
        return clefWorkflowEngine.stageContract
            .run {
                create()
            }
    }

    override fun details(key: String): ContractResponse<StageDetailsResponse> {
        return clefWorkflowEngine.stageContract.details(key)
    }

    override fun enable(key: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageContract.enable(key)
    }

    override fun disable(key: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageContract.disable(key)
    }

    override fun delete(key: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageContract.delete(key)
    }
}