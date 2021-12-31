package io.arkitik.clef.workflow.api.adapter.element.creator

import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.entity.element.Element
import io.arkitik.clef.workflow.api.entity.element.ElementFlow
import io.arkitik.clef.workflow.api.entity.workflow.StageTask
import io.arkitik.clef.workflow.api.entity.workflow.TaskAction
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.entity.workflow.WorkflowStage
import io.arkitik.clef.workflow.api.store.element.creator.ElementFlowIdentityCreator
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementFlowIdentityCreatorImpl : ElementFlowIdentityCreator {
    private lateinit var element: Element
    private lateinit var fromWorkflow: Workflow
    private lateinit var toWorkflow: Workflow
    private lateinit var fromStage: WorkflowStage
    private lateinit var toStage: WorkflowStage
    private lateinit var fromTask: StageTask
    private lateinit var toTask: StageTask
    private lateinit var action: TaskAction
    private var uuid: String = UUID.randomUUID().toString().replace("-","")

    override fun ElementIdentity.element(): ElementFlowIdentityCreator {
        element = this as Element
        return this@ElementFlowIdentityCreatorImpl
    }

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

    override fun String.uuid(): StoreIdentityCreator<String, ElementFlowIdentity> {
        uuid = this
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun create() =
        ElementFlow(
            element = element,
            fromTask = fromTask,
            toTask = toTask,
            action = action,
            fromWorkflow = fromWorkflow,
            toWorkflow = toWorkflow,
            fromStage = fromStage,
            toStage = toStage,
            uuid = uuid
        )
}
