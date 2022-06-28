package io.arkitik.clef.workflow.api.common.error

import io.arkitik.radix.develop.shared.error.Error
import io.arkitik.clef.workflow.api.common.response.SharedResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
object ElementResponses {
    val ACTION_EXECUTED_SUCCESSFULLY = SharedResponse("CLFWF-ELEMENT-1000", "Action executed successfully.")

    object Errors {
        val ELEMENT_DOES_NOT_EXIST = Error("CLFWF-ELEMENT-1100", "Element does not exist.")
        val CANT_EXECUTE_ACTION = Error("CLFWF-ELEMENT-1200", "Can't execute action into the requested element.")
        val DUPLICATE_TASK_ERROR = Error("CLFWF-ELEMENT-1300", "Element already exist, Element key should be unique.")
        val ERROR_WHILE_ACTION_EXECUTION = Error("CLFWF-ELEMENT-2000", "Error acquired while execute action")
    }
}