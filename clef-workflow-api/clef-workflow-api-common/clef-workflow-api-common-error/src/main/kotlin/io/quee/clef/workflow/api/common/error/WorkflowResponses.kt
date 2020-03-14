package io.quee.clef.workflow.api.common.error

import io.quee.api.develop.shared.error.Error
import io.quee.clef.workflow.api.common.response.SharedResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
object WorkflowResponses {
    val WORKFLOW_ACTIVATED_SUCCESS = SharedResponse("CLFWF-WF-1000", "Workflow activated successfully")

    object Errors {
        val WORKFLOW_DOES_NOT_EXIST = Error("CLFWF-WF-1100", "Workflow does not exist.")
        val DUPLICATE_WORKFLOW_ERROR = Error("CLFWF-WF-1200", "Workflow already exist, Workflow key should be unique.")
    }
}