package io.arkitik.clef.workflow.api.domain.action

import io.arkitik.clef.workflow.api.domain.shared.StatusAwareIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionIdentity : StatusAwareIdentity<String> {
    val actionKey: String
    val actionName: String
    val actionDescription: String
    val sourceTask: TaskIdentity
    val destinationTask: TaskIdentity
}
