package io.quee.clef.workflow.api.adapter.element.creator

import io.quee.clef.workflow.api.adapter.entity.element.ElementFlow
import io.quee.clef.workflow.api.adapter.entity.workflow.StageTask
import io.quee.clef.workflow.api.adapter.entity.workflow.TaskAction
import io.quee.clef.workflow.api.adapter.entity.workflow.Workflow
import io.quee.clef.workflow.api.adapter.entity.workflow.WorkflowStage
import io.quee.clef.workflow.api.adapter.shared.creator.BaseStoreIdentityCreator
import io.quee.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.element.creator.ElementFlowIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementFlowIdentityCreatorImpl : BaseStoreIdentityCreator<ElementFlowIdentity>(), ElementFlowIdentityCreator {
    private lateinit var fromWorkflow: Workflow
    private lateinit var toWorkflow: Workflow
    private lateinit var fromStage: WorkflowStage
    private lateinit var toStage: WorkflowStage
    private lateinit var fromTask: StageTask
    private lateinit var toTask: StageTask
    private lateinit var action: TaskAction
    override fun WorkflowIdentity.fromWorkflow(): ElementFlowIdentityCreator {
        fromWorkflow = this as Workflow
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun WorkflowIdentity.toWorkflow(): ElementFlowIdentityCreator {
        toWorkflow = this as Workflow
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun StageIdentity.fromStage(): ElementFlowIdentityCreator {
        fromStage = this as WorkflowStage
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun StageIdentity.toStage(): ElementFlowIdentityCreator {
        toStage = this as WorkflowStage
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun StageTaskIdentity.fromTask(): ElementFlowIdentityCreator {
        fromTask = this as StageTask
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun StageTaskIdentity.toTask(): ElementFlowIdentityCreator {
        toTask = this as StageTask
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun TaskActionIdentity.action(): ElementFlowIdentityCreator {
        action = this as TaskAction
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun create(): ElementFlowIdentity {
        return ElementFlow(fromTask, toTask, action, fromWorkflow, toWorkflow, fromStage, toStage, identityStatus = identityStatus)
    }
}