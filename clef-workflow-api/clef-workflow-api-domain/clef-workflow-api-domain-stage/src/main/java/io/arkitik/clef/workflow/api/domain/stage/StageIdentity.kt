package io.arkitik.clef.workflow.api.domain.stage

import io.arkitik.clef.workflow.api.domain.shared.StatusAwareIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageIdentity : StatusAwareIdentity<String> {
    val stageKey: String
    val stageName: String
    val workflow: WorkflowIdentity
}
