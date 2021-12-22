package io.arkitik.clef.workflow.api.sdk.stage

import io.arkitik.radix.develop.operation.Operation
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.sdk.stage.dto.CreateStageDto
import io.arkitik.clef.workflow.api.sdk.stage.dto.StageDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:02 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
interface StageSdk {
    val createStage: Operation<CreateStageDto, SdkResponse<KeyUuidDto>>
    val stageDetails: Operation<String, SdkResponse<StageDto>>
    val enableStage: Operation<String, SdkResponse<CodeMessageDto>>
    val disableStage: Operation<String, SdkResponse<CodeMessageDto>>
    val deleteStage: Operation<String, SdkResponse<CodeMessageDto>>
}