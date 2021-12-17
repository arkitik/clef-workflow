package io.quee.clef.workflow.api.adapter.task.creator

import io.quee.clef.workflow.api.entity.workflow.StageTask
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.task.creator.StageTaskCreator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageTaskCreatorImpl : StageTaskCreator {
    private var uuid: String = UUID.randomUUID().toString()
    private lateinit var taskKey: String
    private lateinit var taskName: String

    override fun String.uuid(): StageTaskCreator {
        uuid = this
        return this@StageTaskCreatorImpl
    }

    override fun String.taskKey(): StageTaskCreator {
        taskKey = this
        return this@StageTaskCreatorImpl
    }

    override fun String.taskName(): StageTaskCreator {
        taskName = this
        return this@StageTaskCreatorImpl
    }

    override fun create(): StageTaskIdentity {
        return StageTask(taskKey, taskName)
    }
}