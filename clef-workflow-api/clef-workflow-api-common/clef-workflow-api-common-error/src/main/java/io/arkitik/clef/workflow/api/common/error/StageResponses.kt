package io.arkitik.clef.workflow.api.common.error

import io.arkitik.radix.develop.shared.error.Error
import io.arkitik.clef.workflow.api.common.response.SharedResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
object StageResponses {
    val STAGE_ENABLED_SUCCESS = SharedResponse("CLFWF-STAGE-1000", "Task action activated successfully")
    val STAGE_DISABLED_SUCCESS = SharedResponse("CLFWF-STAGE-1100", "Task action disabled successfully")
    val STAGE_DELETED_SUCCESS = SharedResponse("CLFWF-STAGE-1200", "Task action deleted successfully")

    object Errors {
        val STAGE_DOES_NOT_EXIST = Error("CLFWF-STAGE-1300", "Stage does not exist.")
        val DUPLICATE_STAGE_ERROR = Error("CLFWF-STAGE-1400", "Stage already exist, Stage key should be unique.")
        val INITIAL_TASK_HAS_BEEN_ADDED_BEFORE = Error("CLFWF-STAGE-1300", "Stage initial task has been added before.")
        val STAGE_DOES_NOT_HAVE_INITIAL_TASK = Error("CLFWF-STAGE-1400", "Stage does not have initial task.")
    }
}