package io.quee.clef.workflow.api.controller.stage.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.stage.dto.CreateStageRequestDto
import io.quee.clef.workflow.api.controller.stage.contract.StageApiContract
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
    override fun CreateStageRequestDto.create(): ContractResponse<ViewIdentify> {
        return clefWorkflowEngine.stageContract
                .run {
                    create()
                }
    }

    override fun details(key: String, uuid: String): ContractResponse<StageDetailsResponse> {
        return clefWorkflowEngine.stageContract.details(key, uuid)
    }

    override fun enable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageContract.enable(key, uuid)
    }

    override fun disable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageContract.disable(key, uuid)
    }

    override fun delete(key: String, uuid: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageContract.delete(key, uuid)
    }
}