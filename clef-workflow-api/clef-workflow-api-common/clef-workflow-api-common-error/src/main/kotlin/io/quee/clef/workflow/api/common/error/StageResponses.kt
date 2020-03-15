package io.quee.clef.workflow.api.common.error

import io.quee.api.develop.shared.error.Error
import io.quee.clef.workflow.api.common.response.SharedResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
object StageResponses {
    val STAGE_ENABLED_SUCCESS = SharedResponse("CLFWF-TASK-ACT-1000", "Task action activated successfully")
    val STAGE_DISABLED_SUCCESS = SharedResponse("CLFWF-TASK-ACT-1100", "Task action disabled successfully")
    val STAGE_DELETED_SUCCESS = SharedResponse("CLFWF-TASK-ACT-1200", "Task action deleted successfully")

    object Errors {
        val STAGE_DOES_NOT_EXIST = Error("CLFWF-TASK-ACT-1300", "Task action does not exist.")
        val DUPLICATE_STAGE_ERROR = Error("CLFWF-TASK-ACT-1400", "Task action already exist, Task action key should be unique.")
    }
}