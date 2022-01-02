package io.arkitik.clef.workflow.api.adapter.action.creator

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.action.creator.ActionCreator
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ActionCreatorImpl : ActionCreator {
    private lateinit var actionKey: String
    private lateinit var actionName: String
    private lateinit var actionDescription: String
    private lateinit var destinationTask: TaskIdentity
    private lateinit var sourceTask: TaskIdentity
    private var uuid = UUID.randomUUID().toString().replace("-", "")

    override fun String.uuid(): StoreIdentityCreator<String, ActionIdentity> {
        uuid = this
        return this@ActionCreatorImpl
    }

    override fun String.actionKey(): ActionCreator {
        actionKey = this
        return this@ActionCreatorImpl
    }

    override fun String.actionName(): ActionCreator {
        actionName = this
        return this@ActionCreatorImpl
    }

    override fun String.actionDescription(): ActionCreator {
        actionDescription = this
        return this@ActionCreatorImpl
    }

    override fun TaskIdentity.destinationTask(): ActionCreator {
        destinationTask = this
        return this@ActionCreatorImpl
    }

    override fun TaskIdentity.sourceTask(): ActionCreator {
        sourceTask = this
        return this@ActionCreatorImpl
    }

    override fun create() =
        Action(
            actionKey = actionKey,
            actionName = actionName,
            actionDescription = actionDescription,
            destinationTask = destinationTask as Task,
            sourceTask = sourceTask as Task,
            uuid = uuid,
        )
}
