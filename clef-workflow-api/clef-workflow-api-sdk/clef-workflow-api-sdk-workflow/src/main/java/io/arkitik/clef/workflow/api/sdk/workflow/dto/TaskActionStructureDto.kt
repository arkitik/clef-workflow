package io.arkitik.clef.workflow.api.sdk.workflow.dto

import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:14 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class TaskActionStructureDto(
    val actionUuid: String,
    val actionKey: String,
    val actionName: String,
    val status: String,
    val actionDescription: String,
    val destinationTask: KeyUuidDto,
)