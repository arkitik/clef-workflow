package io.arkitik.clef.workflow.api.common.error

import io.arkitik.radix.develop.shared.error.Error
import io.arkitik.clef.workflow.api.common.response.SharedResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
object StageTaskResponses {
    val TASK_ENABLED_SUCCESS = SharedResponse("CLFWF-STAGE_TASK-1000", "Task activated successfully")
    val TASK_DISABLED_SUCCESS = SharedResponse("CLFWF-STAGE_TASK-1100", "Task disabled successfully")
    val TASK_DELETED_SUCCESS = SharedResponse("CLFWF-STAGE_TASK-1200", "Task deleted successfully")

    object Errors {
        val TASK_DOES_NOT_EXIST = Error("CLFWF-STAGE_TASK-1300", "Task does not exist.")
        val DUPLICATE_TASK_ERROR = Error("CLFWF-STAGE_TASK-1400", "Task already exist, Task key should be unique.")
        val INITIAL_TASK_HAS_BEEN_ADDED_BEFORE = Error("CLFWF-TASK-INIT-1000", "Stage initial task has been added before.")
        val STAGE_DOES_NOT_HAVE_INITIAL_TASK = Error("CLFWF-STAGE-INIT-1000", "Stage does not have initial task.")
    }
}
