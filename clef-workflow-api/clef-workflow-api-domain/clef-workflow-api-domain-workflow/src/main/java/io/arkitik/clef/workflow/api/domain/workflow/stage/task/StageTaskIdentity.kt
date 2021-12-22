package io.arkitik.clef.workflow.api.domain.workflow.stage.task

import io.arkitik.clef.workflow.api.domain.shared.StatusAwareIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageTaskIdentity : StatusAwareIdentity<String> {
    val taskKey: String
    val taskName: String
    val actions: List<TaskActionIdentity>
}