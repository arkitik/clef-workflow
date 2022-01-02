package io.arkitik.clef.workflow.api.adapter.element.creator

import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.entity.element.Element
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.element.creator.ElementIdentityCreator
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementIdentityCreatorImpl : ElementIdentityCreator {
    private lateinit var elementKey: String
    private lateinit var currentTask: Task
    private var uuid: String = UUID.randomUUID().toString().replace("-", "")

    override fun String.elementKey(): ElementIdentityCreator {
        elementKey = this
        return this@ElementIdentityCreatorImpl
    }

    override fun TaskIdentity.currentTask(): ElementIdentityCreator {
        currentTask = this as Task
        return this@ElementIdentityCreatorImpl
    }

    override fun String.uuid(): StoreIdentityCreator<String, ElementIdentity> {
        uuid = this
        return this@ElementIdentityCreatorImpl
    }

    override fun create() =
        Element(
            elementKey = elementKey,
            task = currentTask,
            uuid = uuid
        )

}
