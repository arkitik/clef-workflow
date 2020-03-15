package io.quee.clef.workflow.api.store.workflow.updater

import io.quee.api.develop.store.StoreIdentityUpdater
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface WorkflowIdentityUpdater : StoreIdentityUpdater<WorkflowIdentity> {
    fun StageIdentity.initialStage(): WorkflowIdentityUpdater
    fun MutableList<StageIdentity>.addStages(): WorkflowIdentityUpdater
}