package io.quee.clef.workflow.api.store.workflow.creator

import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.store.StoreIdentityCreator
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.store.workflow.model.FakeWorkflowIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
class FakeWorkflowIdentityCreator : WorkflowIdentityCreator {
    private var workflowKey: String? = null
    private var workflowName: String? = null
    private var workflowDescription: String? = null
    private var identityStatus: IdentityStatus = IdentityStatus.ENABLED

    override fun String.workflowKey(): WorkflowIdentityCreator {
        workflowKey = this
        return this@FakeWorkflowIdentityCreator
    }

    override fun String.workflowName(): WorkflowIdentityCreator {
        workflowName = this
        return this@FakeWorkflowIdentityCreator
    }

    override fun String.workflowDescription(): WorkflowIdentityCreator {
        workflowDescription = this
        return this@FakeWorkflowIdentityCreator

    }

    override fun enable(): StoreIdentityCreator<WorkflowIdentity> {
        identityStatus = IdentityStatus.ENABLED
        return this@FakeWorkflowIdentityCreator

    }

    override fun disable(): StoreIdentityCreator<WorkflowIdentity> {
        identityStatus = IdentityStatus.DISABLED
        return this@FakeWorkflowIdentityCreator
    }

    override fun create(): WorkflowIdentity {
        return FakeWorkflowIdentity(workflowKey!!, workflowName!!, workflowDescription!!, identityStatus = identityStatus)
    }
}