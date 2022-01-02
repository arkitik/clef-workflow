package io.arkitik.clef.workflow.api.adapter.task.creator

import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.store.task.creator.TaskCreator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskCreatorImpl : TaskCreator {
    private lateinit var taskKey: String
    private lateinit var taskName: String
    private lateinit var stage: StageIdentity
    private var uuid: String = UUID.randomUUID().toString().replace("-", "")

    override fun String.uuid(): TaskCreator {
        uuid = this
        return this@TaskCreatorImpl
    }

    override fun String.taskKey(): TaskCreator {
        taskKey = this
        return this@TaskCreatorImpl
    }

    override fun String.taskName(): TaskCreator {
        taskName = this
        return this@TaskCreatorImpl
    }

    override fun StageIdentity.stage(): TaskCreator {
        stage = this
        return this@TaskCreatorImpl
    }

    override fun create() =
        Task(
            taskKey = taskKey,
            taskName = taskName,
            stage = stage as Stage,
            uuid = uuid
        )
}
