package io.arkitik.clef.workflow.api.adapter.stage.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.clef.workflow.api.entity.workflow.WorkflowStage
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.store.stage.creator.StageIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageIdentityCreatorImpl : StageIdentityCreator {
    private lateinit var stageKey: String
    private lateinit var stageName: String

    override fun String.uuid(): StoreIdentityCreator<String, StageIdentity> {
        TODO("Not yet implemented")
    }

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