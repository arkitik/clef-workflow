package io.quee.clef.workflow.integration.spring.boot.starter.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.task.StageTaskContract
import io.quee.clef.workflow.api.contract.task.dto.CreateTaskRequestDto
import io.quee.clef.workflow.api.contract.task.dto.TaskRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageTaskContractImpl(private val taskUseCaseFactory: TaskUseCaseFactory) : StageTaskContract {
    override fun CreateTaskRequestDto.create(): ContractResponse<ViewIdentify> {
        return taskUseCaseFactory.createTaskUseCase
                .run {
                    ContractResponse(this@create.process())
                }
    }

    override fun details(key: String, uuid: String): ContractResponse<TaskDetailsResponse> {
        return taskUseCaseFactory.taskDetailsUseCase
                .run {
                    ContractResponse(TaskRequestDto(key, uuid).process())
                }
    }

    override fun enable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return taskUseCaseFactory.enableTaskUseCase
                .run {
                    ContractResponse(TaskRequestDto(key, uuid).process())
                }
    }

    override fun disable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return taskUseCaseFactory.disableTaskUseCase
                .run {
                    ContractResponse(TaskRequestDto(key, uuid).process())
                }
    }

    override fun delete(key: String, uuid: String): ContractResponse<SharedResponse> {
        return taskUseCaseFactory.deleteTaskUseCase
                .run {
                    ContractResponse(TaskRequestDto(key, uuid).process())
                }
    }
}