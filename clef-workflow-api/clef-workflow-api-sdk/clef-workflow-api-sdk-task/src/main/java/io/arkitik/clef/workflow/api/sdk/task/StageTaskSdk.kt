package io.arkitik.clef.workflow.api.sdk.task

import io.arkitik.radix.develop.operation.Operation
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.sdk.task.dto.CreateStageTaskDto
import io.arkitik.clef.workflow.api.sdk.task.dto.StageTaskDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:06 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
interface StageTaskSdk {
    val createStageTask: Operation<CreateStageTaskDto, SdkResponse<KeyUuidDto>>
    val stageTaskDetails: Operation<String, SdkResponse<StageTaskDto>>
    val enableStageTask: Operation<String, SdkResponse<CodeMessageDto>>
    val disableStageTask: Operation<String, SdkResponse<CodeMessageDto>>
    val deleteStageTask: Operation<String, SdkResponse<CodeMessageDto>>

}