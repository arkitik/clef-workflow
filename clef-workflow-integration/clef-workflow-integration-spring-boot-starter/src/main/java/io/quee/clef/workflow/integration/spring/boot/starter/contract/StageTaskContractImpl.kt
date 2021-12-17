package io.quee.clef.workflow.integration.spring.boot.starter.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.task.StageTaskContract
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageTaskContractImpl(private val taskUseCaseFactory: TaskUseCaseFactory) : StageTaskContract {
    override fun CreateTaskRequest.create(): ContractResponse<ViewIdentify> {
        return taskUseCaseFactory.createTaskUseCase
            .run {
                ContractResponse(this@create.process())
            }
    }

    override fun details(key: String): ContractResponse<TaskDetailsResponse> {
        return taskUseCaseFactory.taskDetailsUseCase
            .run {
                ContractResponse(TaskRequest(key).process())
            }
    }

    override fun enable(key: String): ContractResponse<SharedResponse> {
        return taskUseCaseFactory.enableTaskUseCase
            .run {
                ContractResponse(TaskRequest(key).process())
            }
    }

    override fun disable(key: String): ContractResponse<SharedResponse> {
        return taskUseCaseFactory.disableTaskUseCase
            .run {
                ContractResponse(TaskRequest(key).process())
            }
    }

    override fun delete(key: String): ContractResponse<SharedResponse> {
        return taskUseCaseFactory.deleteTaskUseCase
            .run {
                ContractResponse(TaskRequest(key).process())
            }
    }
}