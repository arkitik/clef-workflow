package io.quee.clef.workflow.api.store.workflow.updater

import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.store.StoreIdentityUpdater
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.workflow.model.FakeWorkflowIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FakeWorkflowIdentityUpdater(private val fakeWorkflowIdentity: FakeWorkflowIdentity) : WorkflowIdentityUpdater {
    override fun StageIdentity.initialStage(): WorkflowIdentityUpdater {
        fakeWorkflowIdentity.initialStage = this
        return this@FakeWorkflowIdentityUpdater
    }

    override fun StageIdentity.addStage(): WorkflowIdentityUpdater {
        fakeWorkflowIdentity.stages.add(this)
        return this@FakeWorkflowIdentityUpdater
    }

    override fun MutableList<StageIdentity>.addStages(): WorkflowIdentityUpdater {
        fakeWorkflowIdentity.stages.addAll(this)
        return this@FakeWorkflowIdentityUpdater
    }

    override fun delete(): StoreIdentityUpdater<WorkflowIdentity> {
        fakeWorkflowIdentity.identityStatus = IdentityStatus.DELETED
        return this@FakeWorkflowIdentityUpdater
    }

    override fun enable(): StoreIdentityUpdater<WorkflowIdentity> {
        fakeWorkflowIdentity.identityStatus = IdentityStatus.ENABLED
        return this@FakeWorkflowIdentityUpdater
    }

    override fun disable(): StoreIdentityUpdater<WorkflowIdentity> {
        fakeWorkflowIdentity.identityStatus = IdentityStatus.DISABLED
        return this@FakeWorkflowIdentityUpdater
    }

    override fun update(): WorkflowIdentity = fakeWorkflowIdentity
}