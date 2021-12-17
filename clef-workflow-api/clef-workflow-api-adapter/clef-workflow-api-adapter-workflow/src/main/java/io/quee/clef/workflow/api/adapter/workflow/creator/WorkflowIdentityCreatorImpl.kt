package io.quee.clef.workflow.api.adapter.workflow.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.quee.clef.workflow.api.entity.workflow.Workflow
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.store.workflow.creator.WorkflowIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowIdentityCreatorImpl : WorkflowIdentityCreator {
    private lateinit var workflowKey: String
    private lateinit var workflowName: String
    private lateinit var workflowDescription: String

    override fun String.workflowKey(): WorkflowIdentityCreator {
        workflowKey = this
        return this@WorkflowIdentityCreatorImpl
    }

    override fun String.workflowName(): WorkflowIdentityCreator {
        workflowName = this
        return this@WorkflowIdentityCreatorImpl
    }

    override fun String.workflowDescription(): WorkflowIdentityCreator {
        workflowDescription = this
        return this@WorkflowIdentityCreatorImpl
    }

    override fun create(): WorkflowIdentity {
        return Workflow(workflowKey, workflowName, workflowDescription)
    }

    override fun String.uuid(): StoreIdentityCreator<String, WorkflowIdentity> {
        TODO("Not yet implemented")
    }
}