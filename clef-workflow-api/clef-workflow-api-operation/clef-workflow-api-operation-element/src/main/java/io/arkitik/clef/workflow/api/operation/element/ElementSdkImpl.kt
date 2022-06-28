package io.arkitik.clef.workflow.api.operation.element

import io.arkitik.clef.workflow.api.common.error.ElementResponses
import io.arkitik.clef.workflow.api.function.action.bean.store.ActionBeanStore
import io.arkitik.radix.develop.operation.ext.operationBuilder
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.clef.workflow.api.sdk.element.ElementSdk
import io.arkitik.clef.workflow.api.sdk.element.dto.*
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.ElementByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
import io.arkitik.radix.develop.shared.ext.unprocessableEntity
import java.lang.RuntimeException

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 20 11:45 PM, **Mon, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
class ElementSdkImpl(
    private val elementUseCaseFactory: ElementUseCaseFactory,
    private val actionBeanStore: ActionBeanStore
) : ElementSdk {
    override val createElement = operationBuilder<CreateElementDto, SdkResponse<KeyUuidDto>> {
        mainOperation {
            val response = elementUseCaseFactory.functional {
                createElementUseCase
            } process CreateElementRequest(
                elementKey,
                ElementByKeyRequest(workflow.key)
            )
            SdkResponse(
                KeyUuidDto(
                    response.uuid,
                    response.key
                )
            )
        }
    }

    override val executeAction = operationBuilder<ExecuteActionDto, SdkResponse<CodeMessageDto>> {
        install {
            elementUseCaseFactory.functional {
                actionAvailableExecuteUseCase
            }.process(
                ExecuteActionRequest(
                    ElementByKeyRequest(elementKey),
                    ElementByKeyRequest(action.key)
                )
            ).takeIf { it.response.not() }?.also {
                throw ElementResponses.Errors.CANT_EXECUTE_ACTION.unprocessableEntity()
            }
        }

        mainOperation {
            actionBeanStore.runCatching {
                findBean(
                    actionCode = action.key
                )?.execute(
                    elementKey = elementKey
                )
            }.onFailure {
                throw ElementResponses.Errors.ERROR_WHILE_ACTION_EXECUTION.unprocessableEntity().initCause(it)
            }

            val response = elementUseCaseFactory.functional {
                executeActionIntoElementUseCase
            } process ExecuteActionRequest(
                ElementByKeyRequest(elementKey),
                ElementByKeyRequest(action.key)
            )
            SdkResponse(
                CodeMessageDto(response.code, response.message)
            )
        }
    }

    override val elementDetails = operationBuilder {
        mainOperation {
            val response = elementUseCaseFactory.functional {
                elementFullDetailsUseCase
            } process ElementByKeyRequest(this)
            SdkResponse(
                ElementFullDetailsDto(
                    elementUuid = response.elementUuid,
                    elementKey = response.elementKey,
                    currentTask = ElementDomainDetailsDto(
                        name = response.currentTask.name,
                        key = response.currentTask.key,
                        uuid = response.currentTask.uuid
                    ),
                    currentStage = ElementDomainDetailsDto(
                        name = response.currentStage.name,
                        key = response.currentStage.key,
                        uuid = response.currentStage.uuid
                    ),
                    currentWorkflow = ElementDomainDetailsDto(
                        name = response.currentWorkflow.name,
                        key = response.currentWorkflow.key,
                        uuid = response.currentWorkflow.uuid
                    ),
                    availableActions = response.availableActions.map { action ->
                        AvailableActionDto(
                            uuid = action.uuid,
                            key = action.key,
                            name = action.name,
                            parameters = action.parameters.map { parameter ->
                                AvailableActionParameterDto(
                                    parameterName = parameter.parameterName,
                                    parameterValue = parameter.parameterValue
                                )
                            }
                        )
                    }
                )
            )
        }
    }
}