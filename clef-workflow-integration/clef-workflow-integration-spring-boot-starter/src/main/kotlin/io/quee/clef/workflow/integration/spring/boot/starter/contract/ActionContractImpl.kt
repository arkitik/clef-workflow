package io.quee.clef.workflow.integration.spring.boot.starter.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.action.ActionContract
import io.quee.clef.workflow.api.contract.action.dto.CreateTaskActionRequestDto
import io.quee.clef.workflow.api.contract.action.dto.TaskActionRequestDto
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskActionUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **23**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ActionContractImpl(private val taskActionUseCaseFactory: TaskActionUseCaseFactory) : ActionContract {
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