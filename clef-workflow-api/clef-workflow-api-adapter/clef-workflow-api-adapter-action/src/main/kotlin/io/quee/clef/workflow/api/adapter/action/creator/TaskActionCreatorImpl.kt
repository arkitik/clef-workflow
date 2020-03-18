package io.quee.clef.workflow.api.adapter.action.creator

import io.quee.clef.workflow.api.adapter.entity.StageTask
import io.quee.clef.workflow.api.adapter.entity.TaskAction
import io.quee.clef.workflow.api.adapter.shared.creator.BaseStoreIdentityCreator
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.action.creator.TaskActionCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionCreatorImpl : BaseStoreIdentityCreator<TaskActionIdentity>(), TaskActionCreator {
    private lateinit var actionKey: String
    private lateinit var actionName: String
    private lateinit var actionDescription: String
    private lateinit var destinationTask: StageTaskIdentity

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

    override fun create(): TaskActionIdentity = TaskAction(actionKey, actionName, actionDescription, destinationTask as StageTask, identityStatus = identityStatus)
}