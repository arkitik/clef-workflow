package io.quee.clef.workflow.api.store.workflow

import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.store.workflow.creator.FakeWorkflowIdentityCreator
import io.quee.clef.workflow.api.store.workflow.creator.WorkflowIdentityCreator
import io.quee.clef.workflow.api.store.workflow.model.FakeWorkflowIdentity
import io.quee.clef.workflow.api.store.workflow.query.FakeWorkflowStoreQuery
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.quee.clef.workflow.api.store.workflow.updater.FakeWorkflowIdentityUpdater
import io.quee.clef.workflow.api.store.workflow.updater.WorkflowIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FakeWorkflowStore : WorkflowStore {
    private val list = ArrayList<WorkflowIdentity>()
    override val storeQuery: WorkflowStoreQuery = FakeWorkflowStoreQuery(list)

    override fun identityCreator(): WorkflowIdentityCreator = FakeWorkflowIdentityCreator()

    override fun WorkflowIdentity.identityUpdater(): WorkflowIdentityUpdater = FakeWorkflowIdentityUpdater(this as FakeWorkflowIdentity)

    override fun WorkflowIdentity.save(): WorkflowIdentity {
        list.add(this)
        return this
    }

    override fun List<WorkflowIdentity>.save(): Iterable<WorkflowIdentity> {
        list.addAll(this)
        return this
    }

}