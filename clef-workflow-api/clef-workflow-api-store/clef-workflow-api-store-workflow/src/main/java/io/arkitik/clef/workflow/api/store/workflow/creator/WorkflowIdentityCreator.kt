package io.arkitik.clef.workflow.api.store.workflow.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface WorkflowIdentityCreator : StoreIdentityCreator<String, WorkflowIdentity> {
    fun String.workflowKey(): WorkflowIdentityCreator
    fun String.workflowName(): WorkflowIdentityCreator
    fun String.workflowDescription(): WorkflowIdentityCreator
}