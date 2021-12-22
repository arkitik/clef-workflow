package io.arkitik.clef.workflow.api.controller.shared

import io.arkitik.radix.develop.shared.error.ErrorResponse
import java.time.LocalDateTime

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class ErrorApiResponse(
    val errors: List<ErrorResponse>,
    val time: LocalDateTime = LocalDateTime.now(),
)