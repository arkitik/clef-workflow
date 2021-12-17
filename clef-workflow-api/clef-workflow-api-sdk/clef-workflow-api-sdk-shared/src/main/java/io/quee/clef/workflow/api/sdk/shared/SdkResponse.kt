package io.quee.clef.workflow.api.sdk.shared

import java.time.LocalDateTime

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 1:46 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class SdkResponse<T>(
    val content: T,
    val time: LocalDateTime = LocalDateTime.now(),
)
