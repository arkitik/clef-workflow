package io.quee.clef.workflow.api.adapter.workflow.updater

import io.quee.clef.workflow.api.adapter.entity.Workflow
import io.quee.clef.workflow.api.adapter.entity.WorkflowStage
import io.quee.clef.workflow.api.adapter.shared.entity.BaseIdentity
import io.quee.clef.workflow.api.adapter.shared.updater.BaseStoreIdentityUpdater
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.workflow.updater.WorkflowIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowIdentityUpdaterImpl(private val workflow: Workflow) : BaseStoreIdentityUpdater<WorkflowIdentity>(), WorkflowIdentityUpdater {
    override fun entity(): BaseIdentity {
        return workflow
    }

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

    override fun update(): WorkflowIdentity {
        return workflow
    }
}