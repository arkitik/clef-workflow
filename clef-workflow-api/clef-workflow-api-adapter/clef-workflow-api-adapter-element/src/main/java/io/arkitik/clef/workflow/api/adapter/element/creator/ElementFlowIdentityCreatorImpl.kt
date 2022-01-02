package io.arkitik.clef.workflow.api.adapter.element.creator

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.element.ElementFlowIdentity
import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.entity.element.Element
import io.arkitik.clef.workflow.api.entity.element.ElementFlow
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
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
    private lateinit var fromStage: Stage
    private lateinit var toStage: Stage
    private lateinit var fromTask: Task
    private lateinit var toTask: Task
    private lateinit var action: Action
    private var uuid: String = UUID.randomUUID().toString().replace("-", "")

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
        fromStage = this as Stage
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun StageIdentity.toStage(): ElementFlowIdentityCreator {
        toStage = this as Stage
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun TaskIdentity.fromTask(): ElementFlowIdentityCreator {
        fromTask = this as Task
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun TaskIdentity.toTask(): ElementFlowIdentityCreator {
        toTask = this as Task
        return this@ElementFlowIdentityCreatorImpl
    }

    override fun ActionIdentity.action(): ElementFlowIdentityCreator {
        action = this as Action
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
