package io.quee.clef.workflow.api.common.error

import io.quee.api.develop.shared.error.Error

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
object SharedErrors {
    object IdentityStatusApi {
        val RECORD_ALREADY_DELETED_ERROR = Error("CLFWF-ID-STTS-1100", "Record already deleted, Deleted record could not be able to do any action on it.")
        val RECORD_ALREADY_ACTIVE_ERROR = Error("CLFWF-ID-STTS-1200", "Record already activated, Only deactivate or delete action available")
        val RECORD_ALREADY_DEACTIVATED_ERROR = Error("CLFWF-ID-STTS-1300", "Record already deactivated, Only activate or delete action available")
    }
}