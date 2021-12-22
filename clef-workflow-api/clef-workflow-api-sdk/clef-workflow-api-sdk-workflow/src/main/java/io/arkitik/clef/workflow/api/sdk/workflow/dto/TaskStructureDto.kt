package io.arkitik.clef.workflow.api.sdk.workflow.dto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:14 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class TaskStructureDto(
    val taskUuid: String,
    val taskKey: String,
    val taskName: String,
    val status: String,
    val actions: List<TaskActionStructureDto>,
)