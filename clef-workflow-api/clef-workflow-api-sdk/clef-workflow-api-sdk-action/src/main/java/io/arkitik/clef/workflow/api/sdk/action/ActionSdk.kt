package io.arkitik.clef.workflow.api.sdk.action

import io.arkitik.radix.develop.operation.Operation
import io.arkitik.clef.workflow.api.sdk.action.dto.CreateTaskActionDto
import io.arkitik.clef.workflow.api.sdk.action.dto.TaskActionDto
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:53 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
interface ActionSdk {
    val createAction: Operation<CreateTaskActionDto, SdkResponse<KeyUuidDto>>
    val actionDetails: Operation<String, SdkResponse<TaskActionDto>>
    val enableAction: Operation<String, SdkResponse<CodeMessageDto>>
    val disableAction: Operation<String, SdkResponse<CodeMessageDto>>
    val deleteAction: Operation<String, SdkResponse<CodeMessageDto>>
}