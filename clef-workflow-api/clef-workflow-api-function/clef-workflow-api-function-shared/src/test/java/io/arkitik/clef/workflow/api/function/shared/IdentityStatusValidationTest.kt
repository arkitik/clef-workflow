package io.arkitik.clef.workflow.api.function.shared

import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
internal class IdentityStatusValidationTest {
    @Test
    internal fun `When validate status is valid, if destination is valid nothing will be thrown`() {
        IdentityStatusValidation().run {
            IdentityStatus.ENABLED.validate(IdentityStatus.DISABLED)
            IdentityStatus.ENABLED.validate(IdentityStatus.DELETED)

            IdentityStatus.DISABLED.validate(IdentityStatus.ENABLED)
            IdentityStatus.DISABLED.validate(IdentityStatus.DELETED)
        }
    }

    @Test
    internal fun `When status is enable, if destination is enabled error will be throw`() {
        assertThrows(NotAcceptableException::class.java) {
            IdentityStatusValidation().run {
                IdentityStatus.ENABLED.validate(IdentityStatus.ENABLED)
            }
        }
    }

    @Test
    internal fun `When status is disabled, if destination is disabled error will be throw`() {
        assertThrows(NotAcceptableException::class.java) {
            IdentityStatusValidation().run {
                IdentityStatus.DISABLED.validate(IdentityStatus.DISABLED)
            }
        }
    }

    @Test
    internal fun `When status is deleted, if destination is deleted again error should be thrown`() {
        assertThrows(NotAcceptableException::class.java) {
            IdentityStatusValidation().run {
                IdentityStatus.DELETED.validate(IdentityStatus.DELETED)
            }
        }
    }

    @Test
    internal fun `When status is deleted, if destination is disabled error should be thrown`() {
        assertThrows(NotAcceptableException::class.java) {
            IdentityStatusValidation().run {
                IdentityStatus.DELETED.validate(IdentityStatus.DISABLED)
            }
        }
    }

    @Test
    internal fun `When status is deleted, if destination is enable error should be thrown`() {
        assertThrows(NotAcceptableException::class.java) {
            IdentityStatusValidation().run {
                IdentityStatus.DELETED.validate(IdentityStatus.ENABLED)
            }
        }
    }
}
