package io.arkitik.clef.workflow.api.sdk.stage.dto

import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:56 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class StageDto(
    val stageUuid: String,
    val stageKey: String,
    val stageName: String,
    val initialTask: KeyUuidDto?,
    val tasks: List<KeyUuidDto>,
)
