package io.arkitik.clef.workflow.api.sdk.element.dto

import io.arkitik.clef.workflow.api.sdk.shared.KeyDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 10:59 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class CreateElementDto(
    val elementKey: String,
    val workflow: KeyDto,
)
