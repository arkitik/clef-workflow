package io.quee.clef.workflow.api.controller.shared

import io.quee.api.develop.shared.error.Error
import java.time.LocalDateTime

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ErrorApiResponse(
        val errors: List<Error>,
        val time: LocalDateTime = LocalDateTime.now()
)