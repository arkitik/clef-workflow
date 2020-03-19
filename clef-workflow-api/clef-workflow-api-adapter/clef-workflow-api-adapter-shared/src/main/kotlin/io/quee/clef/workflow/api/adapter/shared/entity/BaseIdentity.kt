package io.quee.clef.workflow.api.adapter.shared.entity

import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.IdentityStatus
import java.time.LocalDateTime
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
open class BaseIdentity(
        override var uuid: String = UUID.randomUUID().toString(),
        override var creationDate: LocalDateTime = LocalDateTime.now(),
        override var identityStatus: IdentityStatus = IdentityStatus.ENABLED
) : Identity