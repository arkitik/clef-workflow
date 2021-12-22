package io.arkitik.clef.workflow.api.common.error

import io.arkitik.radix.develop.shared.error.Error
import io.arkitik.clef.workflow.api.common.response.SharedResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
object TaskActionResponses {
    val TASK_ACTION_ENABLED_SUCCESS = SharedResponse("CLFWF-TASK-ACT-1000", "Task action activated successfully")
    val TASK_ACTION_DISABLED_SUCCESS = SharedResponse("CLFWF-TASK-ACT-1100", "Task action disabled successfully")
    val TASK_ACTION_DELETED_SUCCESS = SharedResponse("CLFWF-TASK-ACT-1200", "Task action deleted successfully")

    object Errors {
        val TASK_ACTION_DOES_NOT_EXIST = Error("CLFWF-TASK-ACT-1300", "Task action does not exist.")
        val DUPLICATE_TASK_ACTION_ERROR =
            Error("CLFWF-TASK-ACT-1400", "Task action already exist, Task action key should be unique.")
    }
}