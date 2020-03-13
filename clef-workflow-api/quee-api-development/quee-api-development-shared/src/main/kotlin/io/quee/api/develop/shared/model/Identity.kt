package io.quee.api.develop.shared.model

import java.io.Serializable
import java.time.LocalDateTime

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
interface Identity : Serializable {
    val uuid: String
    val creationDate: LocalDateTime
    val identityStatus: IdentityStatus
}