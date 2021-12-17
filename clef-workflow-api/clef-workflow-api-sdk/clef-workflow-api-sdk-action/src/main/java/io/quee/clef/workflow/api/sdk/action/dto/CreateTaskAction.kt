package io.quee.clef.workflow.api.sdk.action.dto

import io.quee.clef.workflow.api.sdk.shared.KeyUuidDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:58 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class CreateTaskAction(
    val actionKey: String,
    val actionName: String,
    val actionDescription: String,
    val sourceTask: KeyUuidDto,
    val destinationTask: KeyUuidDto,
    val parameters: List<TaskActionParamDetails> = ArrayList(),
)
