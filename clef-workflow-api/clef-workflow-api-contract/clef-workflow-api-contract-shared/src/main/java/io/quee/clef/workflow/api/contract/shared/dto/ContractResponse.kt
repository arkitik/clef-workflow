package io.quee.clef.workflow.api.contract.shared.dto

import java.time.LocalDateTime

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **23**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class ContractResponse<T>(
    val content: T,
    val time: LocalDateTime = LocalDateTime.now(),
)