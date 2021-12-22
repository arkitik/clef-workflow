package io.arkitik.clef.workflow.api.store.workflow

import io.arkitik.radix.develop.store.Store
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.store.workflow.creator.WorkflowIdentityCreator
import io.arkitik.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.arkitik.clef.workflow.api.store.workflow.updater.WorkflowIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface WorkflowStore : Store<String,WorkflowIdentity> {
    override val storeQuery: WorkflowStoreQuery

    override fun identityCreator(): WorkflowIdentityCreator

    override fun WorkflowIdentity.identityUpdater(): WorkflowIdentityUpdater
}