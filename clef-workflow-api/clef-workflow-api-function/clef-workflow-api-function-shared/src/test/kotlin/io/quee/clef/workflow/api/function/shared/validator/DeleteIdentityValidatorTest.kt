package io.quee.clef.workflow.api.function.shared.validator

import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.common.error.SharedErrors
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
internal class DeleteIdentityValidatorTest {
    @Test
    internal fun `if destination is enabled error will be throw`() {
        val notAcceptableException = assertThrows(NotAcceptableException::class.java) {
            DeleteIdentityValidator().run {
                IdentityStatus.ENABLED.validate()
            }
        }
        assertEquals(notAcceptableException.error, SharedErrors.IdentityStatusApi.RECORD_ALREADY_DELETED_ERROR)
    }

    @Test
    internal fun `if destination is disabled error will be throw`() {
        val notAcceptableException = assertThrows(NotAcceptableException::class.java) {
            DeleteIdentityValidator().run {
                IdentityStatus.DISABLED.validate()
            }
        }
        assertEquals(notAcceptableException.error, SharedErrors.IdentityStatusApi.RECORD_ALREADY_DELETED_ERROR)
    }

    @Test
    internal fun `if destination is deleted error will be throw`() {
        val notAcceptableException = assertThrows(NotAcceptableException::class.java) {
            DeleteIdentityValidator().run {
                IdentityStatus.DELETED.validate()
            }
        }
        assertEquals(notAcceptableException.error, SharedErrors.IdentityStatusApi.RECORD_ALREADY_DELETED_ERROR)
    }
}