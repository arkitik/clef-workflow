package io.quee.clef.workflow.api.sdk.action

import io.quee.clef.workflow.api.sdk.action.dto.CreateTaskAction
import io.quee.clef.workflow.api.sdk.action.dto.TaskActionDetails
import io.quee.clef.workflow.api.sdk.shared.CodeMessageResponse
import io.quee.clef.workflow.api.sdk.shared.KeyUuidDto
import io.quee.clef.workflow.api.sdk.shared.SdkResponse

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:53 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
interface ActionSdk {
    fun create(
        createTaskAction: CreateTaskAction,
    ): SdkResponse<KeyUuidDto>

    fun details(
        key: String, uuid: String,
    ): SdkResponse<TaskActionDetails>

    fun enable(
        key: String, uuid: String,
    ): SdkResponse<CodeMessageResponse>

    fun disable(
        key: String, uuid: String,
    ): SdkResponse<CodeMessageResponse>

    fun delete(
        key: String, uuid: String,
    ): SdkResponse<CodeMessageResponse>
}