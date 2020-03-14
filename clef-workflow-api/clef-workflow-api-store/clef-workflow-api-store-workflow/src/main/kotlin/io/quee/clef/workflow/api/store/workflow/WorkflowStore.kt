package io.quee.clef.workflow.api.store.workflow

import io.quee.api.develop.store.Store
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.store.workflow.creator.WorkflowIdentityCreator
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.quee.clef.workflow.api.store.workflow.updater.WorkflowIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface WorkflowStore : Store<WorkflowIdentity> {
    override val storeQuery: WorkflowStoreQuery

    override fun identityCreator(): WorkflowIdentityCreator

    override fun WorkflowIdentity.identityUpdater(): WorkflowIdentityUpdater
}