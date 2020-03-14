package io.quee.clef.workflow.api.function.shared.validator

import io.quee.api.develop.shared.error.Error
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.shared.func.Validator
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.common.error.SharedErrors
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
class ActivateIdentityValidator : Validator<IdentityStatus> {
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
        activateValidationMap[IdentityStatus.ENABLED] = SharedErrors.IdentityStatusApi.RECORD_ALREADY_ACTIVE_ERROR
    }
}