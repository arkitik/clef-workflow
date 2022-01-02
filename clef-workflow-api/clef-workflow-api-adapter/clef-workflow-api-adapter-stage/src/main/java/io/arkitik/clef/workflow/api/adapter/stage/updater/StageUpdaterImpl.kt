package io.arkitik.clef.workflow.api.adapter.stage.updater

import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.store.stage.updater.StageUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageUpdaterImpl(
    private val stage: Stage,
) : StageUpdater {
    override fun disable(): StageUpdater {
        stage.identityStatus = IdentityStatus.DISABLED
        return this
    }

    override fun enable(): StageUpdater {
        stage.identityStatus = IdentityStatus.ENABLED
        return this
    }

    override fun delete(): StageUpdater {
        stage.identityStatus = IdentityStatus.DELETED
        return this
    }

    override fun update(): StageIdentity = stage
}
