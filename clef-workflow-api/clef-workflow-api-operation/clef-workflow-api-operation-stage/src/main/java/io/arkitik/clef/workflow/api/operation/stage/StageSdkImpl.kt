package io.arkitik.clef.workflow.api.operation.stage

import io.arkitik.radix.develop.operation.ext.operationBuilder
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.sdk.stage.StageSdk
import io.arkitik.clef.workflow.api.sdk.stage.dto.CreateStageDto
import io.arkitik.clef.workflow.api.sdk.stage.dto.StageDto
import io.arkitik.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.DomainKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:45 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
class StageSdkImpl(
    private val stageUseCaseFactory: StageUseCaseFactory,
) : StageSdk {
    override val createStage = operationBuilder<CreateStageDto, SdkResponse<KeyUuidDto>> {
        mainOperation {
            val viewIdentify = stageUseCaseFactory.functional {
                createStageUseCase
            } process CreateStageRequest(
                stageKey = stageKey,
                stageName = stageName,
                initialStage = initialStage,
                workflow = DomainKeyRequest(workflow.key)
            )
            SdkResponse(KeyUuidDto(viewIdentify.uuid, viewIdentify.key))
        }
    }

    override val stageDetails = operationBuilder<String, SdkResponse<StageDto>> {
        mainOperation {
            val response = stageUseCaseFactory.functional {
                stageDetailsUseCase
            } process StageRequest(this)
            SdkResponse(
                StageDto(
                    stageUuid = response.stageUuid,
                    stageKey = response.stageKey,
                    stageName = response.stageName,
                    initialTask = response.initialTask?.let {
                        KeyUuidDto(
                            uuid = it.uuid,
                            key = it.key,
                        )
                    },
                    tasks = response.tasks.map {
                        KeyUuidDto(it.uuid, it.key)
                    }
                ))
        }
    }

    override val enableStage = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = stageUseCaseFactory.functional {
                enableStageUseCase
            } process StageRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }

    override val disableStage = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = stageUseCaseFactory.functional {
                disableStageUseCase
            } process StageRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }
    override val deleteStage = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = stageUseCaseFactory.functional {
                deleteStageUseCase
            } process StageRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }
}