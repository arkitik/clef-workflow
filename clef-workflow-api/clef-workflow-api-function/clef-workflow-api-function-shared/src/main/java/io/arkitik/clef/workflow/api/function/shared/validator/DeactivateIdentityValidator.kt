package io.arkitik.clef.workflow.api.function.shared.validator

import io.arkitik.radix.develop.shared.error.Error
import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.function.shared.Validator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DeactivateIdentityValidator : Validator<IdentityStatus> {
    private val activateValidationMap: MutableMap<IdentityStatus, Error>

    override fun IdentityStatus.validate() {
        val error = activateValidationMap[this]
        when {
            error != null -> {
                throw NotAcceptableException(error)
            }
        }
    }

    init {
        activateValidationMap = EnumMap(IdentityStatus::class.java)
        activateValidationMap[IdentityStatus.DISABLED] = SharedErrors.IdentityStatusApi.RECORD_ALREADY_DISABLED_ERROR
    }
}