package io.quee.clef.workflow.api.controller.task.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.task.dto.CreateTaskRequestDto
import io.quee.clef.workflow.api.controller.task.contract.StageTaskApiContract
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse
import io.quee.clef.workflow.integration.engine.ClefWorkflowEngine
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class StageTaskApiController(private val clefWorkflowEngine: ClefWorkflowEngine) : StageTaskApiContract {
    override fun CreateTaskRequestDto.create(): ContractResponse<ViewIdentify> {
        return clefWorkflowEngine.stageTaskContract
                .run {
                    create()
                }
    }

    override fun details(key: String, uuid: String): ContractResponse<TaskDetailsResponse> {
        return clefWorkflowEngine.stageTaskContract.details(key, uuid)
    }

    override fun enable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageTaskContract.enable(key, uuid)
    }

    override fun disable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageTaskContract.disable(key, uuid)
    }

    override fun delete(key: String, uuid: String): ContractResponse<SharedResponse> {
        return clefWorkflowEngine.stageTaskContract.delete(key, uuid)
    }
}