package io.arkitik.clef.workflow.api.sdk.action.dto

import io.arkitik.clef.workflow.api.sdk.shared.KeyDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:58 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class CreateTaskActionDto(
    val actionKey: String,
    val actionName: String,
    val actionDescription: String,
    val sourceTask: KeyDto,
    val destinationTask: KeyDto,
    val parameters: List<TaskActionParamDto> = ArrayList(),
)
