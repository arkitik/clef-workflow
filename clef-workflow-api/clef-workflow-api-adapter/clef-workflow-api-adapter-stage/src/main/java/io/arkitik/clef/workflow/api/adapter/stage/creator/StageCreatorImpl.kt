package io.arkitik.clef.workflow.api.adapter.stage.creator

import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.store.stage.creator.StageCreator
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageCreatorImpl : StageCreator {
    private lateinit var stageKey: String
    private lateinit var stageName: String
    private lateinit var workflow: WorkflowIdentity
    private var uuid = UUID.randomUUID().toString().replace("-", "")

    override fun String.uuid(): StoreIdentityCreator<String, StageIdentity> {
        uuid = this
        return this@StageCreatorImpl
    }

    override fun WorkflowIdentity.workflow(): StageCreator {
        workflow = this
        return this@StageCreatorImpl
    }

    override fun String.stageKey(): StageCreator {
        stageKey = this
        return this@StageCreatorImpl
    }

    override fun String.stageName(): StageCreator {
        stageName = this
        return this@StageCreatorImpl
    }

    override fun create() =
        Stage(
            stageKey = stageKey,
            stageName = stageName,
            workflow = workflow as Workflow,
            uuid = uuid
        )
}
