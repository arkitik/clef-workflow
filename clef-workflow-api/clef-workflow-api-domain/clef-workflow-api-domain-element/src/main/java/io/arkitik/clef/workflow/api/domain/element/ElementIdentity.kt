package io.arkitik.clef.workflow.api.domain.element

import io.arkitik.clef.workflow.api.domain.shared.StatusAwareIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementIdentity : StatusAwareIdentity<String> {
    val elementKey: String
    val task: TaskIdentity
}
