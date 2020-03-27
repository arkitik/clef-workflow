package io.quee.clef.workflow.api.domain.workflow.stage.action

import io.quee.api.develop.shared.model.Identity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface TaskActionIdentity : Identity {
    val actionKey: String
    val actionName: String
    val actionDescription: String
    val destinationTask: StageTaskIdentity
    val parameters: List<TaskActionParameter>
}