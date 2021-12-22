package io.arkitik.clef.workflow.api.sdk.element.dto

import io.arkitik.clef.workflow.api.sdk.shared.KeyDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:01 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class ExecuteActionDto(
    val elementKey: String,
    val action: KeyDto,
)
