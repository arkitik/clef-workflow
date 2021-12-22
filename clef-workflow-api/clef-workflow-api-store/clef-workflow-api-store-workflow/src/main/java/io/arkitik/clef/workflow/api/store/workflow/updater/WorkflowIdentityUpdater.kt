package io.arkitik.clef.workflow.api.store.workflow.updater

import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface WorkflowIdentityUpdater : StoreIdentityUpdater<String, WorkflowIdentity> {
    fun StageIdentity.initialStage(): WorkflowIdentityUpdater
    fun StageIdentity.addStage(): WorkflowIdentityUpdater
    fun MutableList<StageIdentity>.addStages(): WorkflowIdentityUpdater

    fun disable(): WorkflowIdentityUpdater
    fun enable(): WorkflowIdentityUpdater
    fun delete(): WorkflowIdentityUpdater
}