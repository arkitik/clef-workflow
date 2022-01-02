package io.arkitik.clef.workflow.api.adapter.element.updater

import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.entity.element.Element
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.element.updater.ElementIdentityUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementIdentityUpdaterImpl(
    private val element: Element,
) : ElementIdentityUpdater {

    override fun TaskIdentity.task(): ElementIdentityUpdater {
        element.task = this as Task
        return this@ElementIdentityUpdaterImpl
    }

    override fun disable(): ElementIdentityUpdater {
        element.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): ElementIdentityUpdater {
        element.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): ElementIdentityUpdater {
        element.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update(): ElementIdentity = element
}
