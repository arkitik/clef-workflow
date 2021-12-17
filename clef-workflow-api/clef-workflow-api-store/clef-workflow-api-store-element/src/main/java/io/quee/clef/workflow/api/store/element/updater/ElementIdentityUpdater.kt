package io.quee.clef.workflow.api.store.element.updater

import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementIdentityUpdater : StoreIdentityUpdater<String, ElementIdentity> {
    fun WorkflowIdentity.currentWorkflow(): ElementIdentityUpdater
    fun StageIdentity.currentStage(): ElementIdentityUpdater
    fun StageTaskIdentity.currentTask(): ElementIdentityUpdater
    fun ElementFlowIdentity.addFlow(): ElementIdentityUpdater

    fun disable(): ElementIdentityUpdater
    fun enable(): ElementIdentityUpdater
    fun delete(): ElementIdentityUpdater

}