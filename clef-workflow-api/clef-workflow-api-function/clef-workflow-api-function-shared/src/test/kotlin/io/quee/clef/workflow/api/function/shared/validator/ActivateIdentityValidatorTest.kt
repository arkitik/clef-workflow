package io.quee.clef.workflow.api.function.shared.validator

import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.common.error.SharedErrors
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
internal class ActivateIdentityValidatorTest {

    @Test
    internal fun `if destination is enabled error will be throw`() {
        val notAcceptableException = assertThrows(NotAcceptableException::class.java) {
            ActivateIdentityValidator().run {
                IdentityStatus.ENABLED.validate()
            }
        }
        Assertions.assertEquals(notAcceptableException.error, SharedErrors.IdentityStatusApi.RECORD_ALREADY_ACTIVE_ERROR)
    }

    @Test
    internal fun `if destination is disabled nothing will be throw`() {
        ActivateIdentityValidator().run {
            IdentityStatus.DISABLED.validate()
        }
    }

    @Test
    internal fun `if destination is deleted nothing will be throw`() {
        ActivateIdentityValidator().run {
            IdentityStatus.DELETED.validate()
        }
    }
}