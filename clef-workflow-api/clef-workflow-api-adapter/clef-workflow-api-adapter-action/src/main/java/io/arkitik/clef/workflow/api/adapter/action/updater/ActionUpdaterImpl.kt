package io.arkitik.clef.workflow.api.adapter.action.updater

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.store.action.updater.ActionUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ActionUpdaterImpl(
    private val action: Action,
) : ActionUpdater {
    override fun disable(): ActionUpdater {
        action.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): ActionUpdater {
        action.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): ActionUpdater {
        action.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update(): ActionIdentity = action
}
