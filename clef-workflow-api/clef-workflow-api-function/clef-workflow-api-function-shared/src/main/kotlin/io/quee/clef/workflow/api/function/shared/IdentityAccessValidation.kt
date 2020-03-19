package io.quee.clef.workflow.api.function.shared

import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.shared.func.Validator
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.common.error.SharedErrors

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class IdentityAccessValidation : Validator<IdentityStatus> {
    override fun IdentityStatus.validate() {
        when {
            this == IdentityStatus.DISABLED -> throw NotAcceptableException(SharedErrors.IdentityAccessApi.IDENTITY_DISABLED_ERROR)
            this == IdentityStatus.DELETED -> throw NotAcceptableException(SharedErrors.IdentityAccessApi.IDENTITY_DELETED_ERROR)
        }
    }
}