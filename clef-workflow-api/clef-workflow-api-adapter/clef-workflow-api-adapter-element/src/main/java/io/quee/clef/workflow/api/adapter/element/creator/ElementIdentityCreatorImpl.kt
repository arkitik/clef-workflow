package io.quee.clef.workflow.api.adapter.element.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.quee.clef.workflow.api.entity.element.Element
import io.quee.clef.workflow.api.entity.workflow.StageTask
import io.quee.clef.workflow.api.entity.workflow.Workflow
import io.quee.clef.workflow.api.entity.workflow.WorkflowStage
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.element.creator.ElementIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementIdentityCreatorImpl : ElementIdentityCreator {
    private lateinit var elementKey: String
    private lateinit var workflow: Workflow
    private lateinit var currentStage: WorkflowStage
    private lateinit var currentTask: StageTask

    override fun String.elementKey(): ElementIdentityCreator {
        elementKey = this
        return this@ElementIdentityCreatorImpl
    }

    override fun WorkflowIdentity.workflow(): ElementIdentityCreator {
        workflow = this as Workflow
        return this@ElementIdentityCreatorImpl
    }

    override fun StageIdentity.currentStage(): ElementIdentityCreator {
        currentStage = this as WorkflowStage
        return this@ElementIdentityCreatorImpl
    }

    override fun StageTaskIdentity.currentTask(): ElementIdentityCreator {
        currentTask = this as StageTask
        return this@ElementIdentityCreatorImpl
    }

    override fun create(): ElementIdentity {
        return Element(
            elementKey, workflow, currentStage, currentTask
        )
    }

    override fun String.uuid(): StoreIdentityCreator<String, ElementIdentity> {
        TODO("Not yet implemented")
    }

}