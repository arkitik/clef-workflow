package io.arkitik.clef.workflow.api.adapter.workflow.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.store.workflow.creator.WorkflowIdentityCreator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class WorkflowIdentityCreatorImpl : WorkflowIdentityCreator {
    private lateinit var workflowKey: String
    private lateinit var workflowName: String
    private lateinit var workflowDescription: String
    private var uuid: String = UUID.randomUUID().toString().replace("-", "")

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
        uuid = this
        return this@WorkflowIdentityCreatorImpl
    }
}
