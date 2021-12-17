package io.quee.clef.workflow.api.domain.shared

import io.arkitik.radix.develop.identity.Identity
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import java.io.Serializable

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 12:28 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
interface StatusAwareIdentity<ID : Serializable> : Identity<ID> {
    override val uuid: ID
    val identityStatus: IdentityStatus
}