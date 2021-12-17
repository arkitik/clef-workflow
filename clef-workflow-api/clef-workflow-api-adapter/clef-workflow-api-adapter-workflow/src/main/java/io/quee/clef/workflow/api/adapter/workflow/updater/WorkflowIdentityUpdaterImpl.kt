package io.quee.clef.workflow.api.adapter.workflow.updater

import io.quee.clef.workflow.api.entity.workflow.Workflow
import io.quee.clef.workflow.api.entity.workflow.WorkflowStage
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.workflow.updater.WorkflowIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowIdentityUpdaterImpl(
    private val workflow: Workflow,
) : WorkflowIdentityUpdater {
    override fun StageIdentity.initialStage(): WorkflowIdentityUpdater {
        workflow.initialStage = this as WorkflowStage
        return this@WorkflowIdentityUpdaterImpl
    }

    override fun StageIdentity.addStage(): WorkflowIdentityUpdater {
        workflow.stages.add(this as WorkflowStage)
        return this@WorkflowIdentityUpdaterImpl
    }

    override fun MutableList<StageIdentity>.addStages(): WorkflowIdentityUpdater {
        workflow.stages.addAll(map {
            it as WorkflowStage
        })
        return this@WorkflowIdentityUpdaterImpl
    }

    override fun disable(): WorkflowIdentityUpdater {
        this.workflow.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): WorkflowIdentityUpdater {
        this.workflow.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): WorkflowIdentityUpdater {
        this.workflow.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update(): WorkflowIdentity {
        return workflow
    }
}