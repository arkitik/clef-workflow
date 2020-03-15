package io.quee.clef.workflow.api.store.workflow.creator

import io.quee.api.develop.store.StoreIdentityCreator
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface WorkflowIdentityCreator : StoreIdentityCreator<WorkflowIdentity> {
    fun String.workflowKey(): WorkflowIdentityCreator
    fun String.workflowName(): WorkflowIdentityCreator
    fun String.workflowDescription(): WorkflowIdentityCreator
}