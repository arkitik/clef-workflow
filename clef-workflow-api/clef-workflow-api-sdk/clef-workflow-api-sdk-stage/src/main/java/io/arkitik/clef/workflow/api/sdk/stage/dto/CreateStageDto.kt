package io.arkitik.clef.workflow.api.sdk.stage.dto

import io.arkitik.clef.workflow.api.sdk.shared.KeyDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:58 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class CreateStageDto(
    val stageKey: String,
    val stageName: String,
    val initialStage: Boolean,
    val workflow: KeyDto,
)
