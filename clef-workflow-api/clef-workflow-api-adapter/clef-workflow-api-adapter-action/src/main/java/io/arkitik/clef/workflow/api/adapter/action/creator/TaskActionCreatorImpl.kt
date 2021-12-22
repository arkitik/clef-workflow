package io.arkitik.clef.workflow.api.adapter.action.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.clef.workflow.api.entity.workflow.StageTask
import io.arkitik.clef.workflow.api.entity.workflow.TaskAction
import io.arkitik.clef.workflow.api.entity.workflow.embedded.TaskActionParameterImpl
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionParameter
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.store.action.creator.TaskActionCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskActionCreatorImpl : TaskActionCreator {
    private lateinit var actionKey: String
    private lateinit var actionName: String
    private lateinit var actionDescription: String
    private lateinit var destinationTask: StageTaskIdentity

    private val parameters = ArrayList<TaskActionParameterImpl>()

    override fun String.uuid(): StoreIdentityCreator<String, TaskActionIdentity> {
        TODO("Not yet implemented")
    }

    override fun String.actionKey(): TaskActionCreator {
        actionKey = this
        return this@TaskActionCreatorImpl
    }

    override fun String.actionName(): TaskActionCreator {
        actionName = this
        return this@TaskActionCreatorImpl
    }

    override fun String.actionDescription(): TaskActionCreator {
        actionDescription = this
        return this@TaskActionCreatorImpl
    }

    override fun StageTaskIdentity.destinationTask(): TaskActionCreator {
        destinationTask = this
        return this@TaskActionCreatorImpl
    }

    override fun TaskActionParameter.addParam(): TaskActionCreator {
        parameters.add(this as TaskActionParameterImpl)
        return this@TaskActionCreatorImpl
    }

    override fun create() =
        TaskAction(

            actionKey,
            actionName,
            actionDescription,
            destinationTask as StageTask,
            parameters = parameters
        )
}