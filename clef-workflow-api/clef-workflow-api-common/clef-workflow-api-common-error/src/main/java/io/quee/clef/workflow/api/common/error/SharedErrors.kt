package io.quee.clef.workflow.api.common.error

import io.arkitik.radix.develop.shared.error.Error

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
object SharedErrors {
    val INVALID_DATE_FORMAT = Error("CLFWF-COMN-1000", "Invalid date format")
    val UNKNOWN_ERROR = Error("CLFWF-COMN-9999", "Unknown error")

    object IdentityStatusApi {
        val RECORD_ALREADY_DELETED_ERROR = Error("CLFWF-ID-STTS-1100",
            "Record already deleted, Deleted record could not be able to do any action on it.")
        val RECORD_ALREADY_ENABLED_ERROR =
            Error("CLFWF-ID-STTS-1200", "Record already enabled, Only disable or delete action available")
        val RECORD_ALREADY_DISABLED_ERROR =
            Error("CLFWF-ID-STTS-1300", "Record already disabled, Only enable or delete action available")
    }

    object IdentityAccessApi {
        val IDENTITY_DELETED_ERROR = Error("CLFWF-ID-STTS-2100",
            "Record status is deleted, Deleted record could not be able to do any action on it.")
        val IDENTITY_DISABLED_ERROR =
            Error("CLFWF-ID-STTS-2300", "Record status is disabled, You can't access it before it has been active")
    }
}