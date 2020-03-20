package io.quee.clef.workflow.api.adapter.stage.creator

import io.quee.clef.workflow.api.adapter.entity.workflow.WorkflowStage
import io.quee.clef.workflow.api.adapter.shared.creator.BaseStoreIdentityCreator
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.stage.creator.StageIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageIdentityCreatorImpl : BaseStoreIdentityCreator<StageIdentity>(), StageIdentityCreator {
    private lateinit var stageKey: String
    private lateinit var stageName: String
    override fun String.stageKey(): StageIdentityCreator {
        stageKey = this
        return this@StageIdentityCreatorImpl
    }

    override fun String.stageName(): StageIdentityCreator {
        stageName = this
        return this@StageIdentityCreatorImpl
    }

    override fun create(): StageIdentity {
        return WorkflowStage(stageKey, stageName)
    }
}