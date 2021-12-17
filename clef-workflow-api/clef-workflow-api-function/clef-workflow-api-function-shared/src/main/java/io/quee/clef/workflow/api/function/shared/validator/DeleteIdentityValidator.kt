package io.quee.clef.workflow.api.function.shared.validator

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.quee.clef.workflow.api.common.error.SharedErrors
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.function.shared.Validator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DeleteIdentityValidator : Validator<IdentityStatus> {
    override fun IdentityStatus.validate() {
        throw NotAcceptableException(SharedErrors.IdentityStatusApi.RECORD_ALREADY_DELETED_ERROR)
    }
}