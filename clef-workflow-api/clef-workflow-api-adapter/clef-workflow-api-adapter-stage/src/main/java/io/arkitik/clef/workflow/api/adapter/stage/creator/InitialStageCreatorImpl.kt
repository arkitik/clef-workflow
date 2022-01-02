package io.arkitik.clef.workflow.api.adapter.stage.creator

import io.arkitik.clef.workflow.api.domain.stage.InitialStageIdentity
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.entity.stage.InitialStage
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.store.stage.creator.InitialStageCreator
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import java.util.*

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:39 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class InitialStageCreatorImpl : InitialStageCreator {
    private lateinit var workflow: WorkflowIdentity
    private lateinit var stage: StageIdentity
    private var uuid = UUID.randomUUID().toString().replace("-", "")

    override fun String.uuid(): StoreIdentityCreator<String, InitialStageIdentity> {
        uuid = this
        return this@InitialStageCreatorImpl
    }

    override fun WorkflowIdentity.workflow(): InitialStageCreator {
        workflow = this
        return this@InitialStageCreatorImpl
    }

    override fun StageIdentity.stage(): InitialStageCreator {
        stage = this
        return this@InitialStageCreatorImpl
    }

    override fun create() =
        InitialStage(
            stage = stage as Stage,
            workflow = workflow as Workflow,
            uuid = uuid
        )
}
