package io.quee.clef.workflow.api.common.error

import io.arkitik.radix.develop.shared.error.Error
import io.quee.clef.workflow.api.common.response.SharedResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
object ElementResponses {
    val ACTION_EXECUTED_SUCCESSFULLY = SharedResponse("CLFWF-ELEMENT-1000", "Action executed successfully.")

    object Errors {
        val ELEMENT_DOES_NOT_EXIST = Error("CLFWF-ELEMENT-1100", "Element does not exist.")
        val ACTION_CANT_EXECUTE = Error("CLFWF-ELEMENT-1200", "Can't execute action into the element.")
        val DUPLICATE_TASK_ERROR = Error("CLFWF-ELEMENT-1300", "Element already exist, Element key should be unique.")
    }
}