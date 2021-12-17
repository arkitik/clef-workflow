package io.quee.clef.workflow.api.controller.shared

import io.arkitik.radix.develop.shared.error.ErrorResponse
import java.time.LocalDateTime

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class ErrorApiResponse(
    val errors: List<ErrorResponse>,
    val time: LocalDateTime = LocalDateTime.now(),
)