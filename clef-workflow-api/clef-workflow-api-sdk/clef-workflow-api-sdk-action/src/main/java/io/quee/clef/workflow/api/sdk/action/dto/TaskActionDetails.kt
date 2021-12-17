package io.quee.clef.workflow.api.sdk.action.dto

import io.quee.clef.workflow.api.sdk.shared.KeyUuidDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:56 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class TaskActionDetails(
    val actionUuid: String,
    val actionKey: String,
    val actionName: String,
    val actionDescription: String,
    val destinationTask: KeyUuidDto,
    val parameters: List<TaskActionParamDetails>,
)
