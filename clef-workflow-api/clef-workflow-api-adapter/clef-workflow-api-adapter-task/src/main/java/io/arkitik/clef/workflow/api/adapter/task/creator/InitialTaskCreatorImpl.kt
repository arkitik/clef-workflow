package io.arkitik.clef.workflow.api.adapter.task.creator

import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.task.InitialTaskIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.task.InitialTask
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.task.creator.InitialTaskCreator
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import java.util.*

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:51 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class InitialTaskCreatorImpl : InitialTaskCreator {
    private lateinit var task: TaskIdentity
    private lateinit var stage: StageIdentity
    private var uuid: String = UUID.randomUUID().toString().replace("-", "")

    override fun TaskIdentity.task(): InitialTaskCreator {
        task = this
        return this@InitialTaskCreatorImpl
    }

    override fun StageIdentity.stage(): InitialTaskCreator {
        stage = this
        return this@InitialTaskCreatorImpl
    }

    override fun String.uuid(): StoreIdentityCreator<String, InitialTaskIdentity> {
        uuid = this
        return this@InitialTaskCreatorImpl
    }

    override fun create() =
        InitialTask(
            task = task as Task,
            stage = stage as Stage,
            uuid = uuid,
        )
}
