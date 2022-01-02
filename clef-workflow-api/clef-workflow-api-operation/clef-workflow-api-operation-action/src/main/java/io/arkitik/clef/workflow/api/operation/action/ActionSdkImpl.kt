package io.arkitik.clef.workflow.api.operation.action

import io.arkitik.radix.develop.operation.ext.operationBuilder
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.clef.workflow.api.sdk.action.ActionSdk
import io.arkitik.clef.workflow.api.sdk.action.dto.CreateTaskActionDto
import io.arkitik.clef.workflow.api.sdk.action.dto.TaskActionDto
import io.arkitik.clef.workflow.api.sdk.action.dto.TaskActionParamDto
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.usecase.factory.workflow.ActionUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.DomainKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionParamRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:45 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
class ActionSdkImpl(
    private val actionUseCaseFactory: ActionUseCaseFactory,
) : ActionSdk {
    override val createAction = operationBuilder<CreateTaskActionDto, SdkResponse<KeyUuidDto>> {
        mainOperation {
            val viewIdentify = actionUseCaseFactory.functional {
                createActionUseCase
            } process CreateTaskActionRequest(
                actionKey = actionKey,
                actionName = actionName,
                actionDescription = actionDescription,
                sourceTask = DomainKeyRequest(sourceTask.key),
                destinationTask = DomainKeyRequest(destinationTask.key),
                parameters = parameters.map {
                    TaskActionParamRequest(
                        parameterKey = it.parameterKey,
                        parameterValue = it.parameterKey
                    )
                }
            )
            SdkResponse(KeyUuidDto(viewIdentify.uuid, viewIdentify.key))
        }
    }

    override val actionDetails = operationBuilder<String, SdkResponse<TaskActionDto>> {
        mainOperation {
            val response = actionUseCaseFactory.functional {
                actionDetailsUseCase
            } process TaskActionRequest(this)
            SdkResponse(
                TaskActionDto(
                    actionUuid = response.actionUuid,
                    actionKey = response.actionKey,
                    actionName = response.actionName,
                    actionDescription = response.actionDescription,
                    destinationTask = KeyUuidDto(
                        uuid = response.destinationTask.uuid,
                        key = response.destinationTask.key,
                    ),
                    parameters = response.parameters.map {
                        TaskActionParamDto(parameterKey = it.parameterKey, parameterValue = it.parameterKey)
                    }
                ))
        }
    }

    override val enableAction = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = actionUseCaseFactory.functional {
                enableActionUseCase
            } process TaskActionRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }

    override val disableAction = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = actionUseCaseFactory.functional {
                disableActionUseCase
            } process TaskActionRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }
    override val deleteAction = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = actionUseCaseFactory.functional {
                deleteActionUseCase
            } process TaskActionRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }
}
