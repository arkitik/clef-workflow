package io.arkitik.clef.workflow.api.function.shared

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class IdentityAccessValidation : Validator<IdentityStatus> {
    override fun IdentityStatus.validate() {
        when {
            this == IdentityStatus.DISABLED -> throw NotAcceptableException(SharedErrors.IdentityAccessApi.IDENTITY_DISABLED_ERROR)
            this == IdentityStatus.DELETED -> throw NotAcceptableException(SharedErrors.IdentityAccessApi.IDENTITY_DELETED_ERROR)
        }
    }
}