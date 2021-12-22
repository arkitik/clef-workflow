package io.arkitik.clef.workflow.api.sdk.task.dto

import io.arkitik.clef.workflow.api.sdk.shared.KeyDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:58 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class CreateStageTaskDto(
    val taskKey: String,
    val taskName: String,
    val initialTask: Boolean,
    val stage: KeyDto,
)
