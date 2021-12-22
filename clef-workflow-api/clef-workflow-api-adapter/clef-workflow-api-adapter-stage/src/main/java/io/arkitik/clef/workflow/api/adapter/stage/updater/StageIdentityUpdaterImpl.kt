package io.arkitik.clef.workflow.api.adapter.stage.updater

import io.arkitik.clef.workflow.api.entity.workflow.StageTask
import io.arkitik.clef.workflow.api.entity.workflow.WorkflowStage
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.store.stage.updater.StageIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageIdentityUpdaterImpl(
    private val workflowStage: WorkflowStage,
) : StageIdentityUpdater {
    override fun StageTaskIdentity.initialTask(): StageIdentityUpdater {
        workflowStage.initialTask = this as StageTask
        return this@StageIdentityUpdaterImpl
    }

    override fun StageTaskIdentity.addTask(): StageIdentityUpdater {
        workflowStage.tasks.add(this as StageTask)
        return this@StageIdentityUpdaterImpl
    }

    override fun MutableList<StageTaskIdentity>.addTasks(): StageIdentityUpdater {
        workflowStage.tasks.addAll(map {
            it as StageTask
        })
        return this@StageIdentityUpdaterImpl
    }

    override fun disable(): StageIdentityUpdater {
        workflowStage.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): StageIdentityUpdater {
        workflowStage.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): StageIdentityUpdater {
        workflowStage.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update(): StageIdentity = workflowStage
}