package io.quee.clef.workflow.api.usecase.factory.domain.request

import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface AddTaskToStageRequest : UseCaseRequest {
    val stageTaskIdentity: StageTaskIdentity
    val stageIdentity: StageIdentity
    val initialTask: Boolean

    companion object {
        fun instance(
                stageTaskIdentity: StageTaskIdentity,
                stageIdentity: StageIdentity,
                initialTask: Boolean
        ): AddTaskToStageRequest {
            return object : AddTaskToStageRequest {
                override val stageTaskIdentity: StageTaskIdentity = stageTaskIdentity
                override val stageIdentity: StageIdentity = stageIdentity
                override val initialTask: Boolean = initialTask
            }
        }
    }
}