package io.arkitik.clef.workflow.api.sdk.element

import io.arkitik.radix.develop.operation.Operation
import io.arkitik.clef.workflow.api.sdk.element.dto.CreateElementDto
import io.arkitik.clef.workflow.api.sdk.element.dto.ElementFullDetailsDto
import io.arkitik.clef.workflow.api.sdk.element.dto.ExecuteActionDto
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 10:56 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
interface ElementSdk {
    val createElement: Operation<CreateElementDto, SdkResponse<KeyUuidDto>>
    val executeAction: Operation<ExecuteActionDto, SdkResponse<CodeMessageDto>>
    val elementDetails: Operation<String, SdkResponse<ElementFullDetailsDto>>
}