package io.arkitik.clef.workflow.api.store.element.updater

import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementIdentityUpdater : StoreIdentityUpdater<String, ElementIdentity> {
    fun WorkflowIdentity.currentWorkflow(): ElementIdentityUpdater
    fun StageIdentity.currentStage(): ElementIdentityUpdater
    fun StageTaskIdentity.currentTask(): ElementIdentityUpdater

    fun disable(): ElementIdentityUpdater
    fun enable(): ElementIdentityUpdater
    fun delete(): ElementIdentityUpdater

}
