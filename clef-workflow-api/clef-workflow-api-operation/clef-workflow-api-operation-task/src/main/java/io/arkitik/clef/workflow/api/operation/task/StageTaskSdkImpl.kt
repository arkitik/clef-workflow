package io.arkitik.clef.workflow.api.operation.task

import io.arkitik.radix.develop.operation.ext.operationBuilder
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.sdk.task.StageTaskSdk
import io.arkitik.clef.workflow.api.sdk.task.dto.CreateStageTaskDto
import io.arkitik.clef.workflow.api.sdk.task.dto.StageTaskDto
import io.arkitik.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.DomainKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:45 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
class StageTaskSdkImpl(
    private val taskUseCaseFactory: TaskUseCaseFactory,
) : StageTaskSdk {
    override val createStageTask = operationBuilder<CreateStageTaskDto, SdkResponse<KeyUuidDto>> {
        mainOperation {
            val viewIdentify = taskUseCaseFactory.functional {
                createTaskUseCase
            } process CreateTaskRequest(
                taskKey = taskKey,
                taskName = taskName,
                initialTask = initialTask,
                stage = DomainKeyRequest(stage.key)
            )
            SdkResponse(KeyUuidDto(viewIdentify.uuid, viewIdentify.key))
        }
    }

    override val stageTaskDetails = operationBuilder<String, SdkResponse<StageTaskDto>> {
        mainOperation {
            val response = taskUseCaseFactory.functional {
                taskDetailsUseCase
            } process TaskRequest(this)
            SdkResponse(
                StageTaskDto(
                    taskUuid = response.taskUuid,
                    taskKey = response.taskKey,
                    taskName = response.taskName,
                    actions = response.actions.map {
                        KeyUuidDto(it.uuid, it.key)
                    }
                )
            )
        }
    }

    override val enableStageTask = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = taskUseCaseFactory.functional {
                enableTaskUseCase
            } process TaskRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }

    override val disableStageTask = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = taskUseCaseFactory.functional {
                disableTaskUseCase
            } process TaskRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }
    override val deleteStageTask = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = taskUseCaseFactory.functional {
                deleteTaskUseCase
            } process TaskRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }
}