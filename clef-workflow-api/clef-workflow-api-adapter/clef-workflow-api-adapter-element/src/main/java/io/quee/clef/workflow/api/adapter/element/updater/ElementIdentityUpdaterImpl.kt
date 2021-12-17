package io.quee.clef.workflow.api.adapter.element.updater

import io.quee.clef.workflow.api.entity.element.Element
import io.quee.clef.workflow.api.entity.element.ElementFlow
import io.quee.clef.workflow.api.entity.workflow.StageTask
import io.quee.clef.workflow.api.entity.workflow.Workflow
import io.quee.clef.workflow.api.entity.workflow.WorkflowStage
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.element.updater.ElementIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementIdentityUpdaterImpl(
    private val element: Element,
) : ElementIdentityUpdater {
    override fun WorkflowIdentity.currentWorkflow(): ElementIdentityUpdater {
        element.workflow = this as Workflow
        return this@ElementIdentityUpdaterImpl
    }

    override fun StageIdentity.currentStage(): ElementIdentityUpdater {
        element.currentStage = this as WorkflowStage
        return this@ElementIdentityUpdaterImpl
    }

    override fun StageTaskIdentity.currentTask(): ElementIdentityUpdater {
        element.currentTask = this as StageTask
        return this@ElementIdentityUpdaterImpl

    }

    override fun ElementFlowIdentity.addFlow(): ElementIdentityUpdater {
        element.flows.add(this as ElementFlow)
        return this@ElementIdentityUpdaterImpl
    }

    override fun disable(): ElementIdentityUpdater {
        this.element.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): ElementIdentityUpdater {
        this.element.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): ElementIdentityUpdater {
        this.element.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update(): ElementIdentity = element
}