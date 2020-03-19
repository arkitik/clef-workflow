package io.quee.clef.workflow.api.domain.workflow.stage

import io.quee.api.develop.shared.model.Identity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageIdentity : Identity {
    val stageKey: String
    val stageName: String
    val initialTask: StageTaskIdentity?
    val tasks: List<StageTaskIdentity>
}