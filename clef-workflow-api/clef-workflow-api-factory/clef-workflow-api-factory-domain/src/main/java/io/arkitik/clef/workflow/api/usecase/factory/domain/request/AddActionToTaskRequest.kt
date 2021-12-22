package io.arkitik.clef.workflow.api.usecase.factory.domain.request

import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface AddActionToTaskRequest : UseCaseRequest {
    val sourceStageTaskIdentity: StageTaskIdentity
    val taskActionIdentity: TaskActionIdentity

    companion object {
        fun instance(
            stageTaskIdentity: StageTaskIdentity,
            taskActionIdentity: TaskActionIdentity,
        ): AddActionToTaskRequest {
            return object : AddActionToTaskRequest {
                override val sourceStageTaskIdentity: StageTaskIdentity = stageTaskIdentity
                override val taskActionIdentity: TaskActionIdentity = taskActionIdentity
            }
        }
    }
}