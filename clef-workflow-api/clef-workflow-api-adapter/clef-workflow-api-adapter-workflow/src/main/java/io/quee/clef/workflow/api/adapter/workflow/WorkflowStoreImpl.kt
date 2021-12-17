package io.quee.clef.workflow.api.adapter.workflow

import io.arkitik.radix.adapter.shared.StoreImpl
import io.quee.clef.workflow.api.entity.workflow.Workflow
import io.quee.clef.workflow.api.adapter.workflow.creator.WorkflowIdentityCreatorImpl
import io.quee.clef.workflow.api.adapter.workflow.query.WorkflowStoreQueryImpl
import io.quee.clef.workflow.api.adapter.workflow.repository.WorkflowRepository
import io.quee.clef.workflow.api.adapter.workflow.updater.WorkflowIdentityUpdaterImpl
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.store.workflow.creator.WorkflowIdentityCreator
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.quee.clef.workflow.api.store.workflow.updater.WorkflowIdentityUpdater
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Service
class WorkflowStoreImpl(
    workflowRepository: WorkflowRepository,
) : StoreImpl<String, WorkflowIdentity, Workflow>(workflowRepository), WorkflowStore {
    override fun WorkflowIdentity.map(): Workflow = this as Workflow

    override val storeQuery: WorkflowStoreQuery = WorkflowStoreQueryImpl(workflowRepository)

    override fun identityCreator(): WorkflowIdentityCreator = WorkflowIdentityCreatorImpl()

    override fun WorkflowIdentity.identityUpdater(): WorkflowIdentityUpdater = WorkflowIdentityUpdaterImpl(map())
}