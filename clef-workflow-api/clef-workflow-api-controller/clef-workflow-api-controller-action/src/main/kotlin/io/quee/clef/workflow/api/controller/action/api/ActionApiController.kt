package io.quee.clef.workflow.api.controller.action.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.action.dto.CreateTaskActionRequestDto
import io.quee.clef.workflow.api.contract.action.dto.TaskActionRequestDto
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.controller.action.contract.ActionApiContract
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskActionUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class ActionApiController(private val taskActionUseCaseFactory: TaskActionUseCaseFactory) : ActionApiContract {
    override fun CreateTaskActionRequestDto.create(): ContractResponse<ViewIdentify> {
        return taskActionUseCaseFactory.createTaskActionUseCase
                .run {
                    ContractResponse(this@create.process())
                }
    }

    override fun details(key: String, uuid: String): ContractResponse<TaskActionDetails> {
        return taskActionUseCaseFactory.taskActionDetailsUseCase
                .run {
                    ContractResponse(TaskActionRequestDto(key, uuid).process())
                }
    }

    override fun enable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return taskActionUseCaseFactory.enableTaskActionUseCase
                .run {
                    ContractResponse(TaskActionRequestDto(key, uuid).process())
                }
    }

    override fun disable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return taskActionUseCaseFactory.disableTaskActionUseCase
                .run {
                    ContractResponse(TaskActionRequestDto(key, uuid).process())
                }
    }

    override fun delete(key: String, uuid: String): ContractResponse<SharedResponse> {
        return taskActionUseCaseFactory.deleteTaskActionUseCase
                .run {
                    ContractResponse(TaskActionRequestDto(key, uuid).process())
                }
    }
}