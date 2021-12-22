package io.arkitik.clef.workflow.api.function.shared.validator

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
internal class DeactivateIdentityValidatorTest {

    @Test
    internal fun `if destination is disabled error will be throw`() {
        val notAcceptableException = assertThrows(NotAcceptableException::class.java) {
            DeactivateIdentityValidator().run {
                IdentityStatus.DISABLED.validate()
            }
        }
        Assertions.assertEquals(notAcceptableException.error,
            SharedErrors.IdentityStatusApi.RECORD_ALREADY_DISABLED_ERROR)
    }

    @Test
    internal fun `if destination is enabled nothing will be throw`() {
        DeactivateIdentityValidator().run {
            IdentityStatus.ENABLED.validate()
        }
    }

    @Test
    internal fun `if destination is deleted nothing will be throw`() {
        DeactivateIdentityValidator().run {
            IdentityStatus.DELETED.validate()
        }
    }
}