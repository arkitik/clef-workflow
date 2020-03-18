package io.quee.clef.workflow.api.domain.workflow.stage.task

import io.quee.api.develop.shared.model.Identity
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageTaskIdentity : Identity {
    val taskKey: String
    val taskName: String
    val actions: List<TaskActionIdentity>
}