package io.arkitik.clef.workflow.api.usecase.task.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskDetailsUseCase(
    private val taskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskRequest, TaskDetailsResponse>() {
    override fun TaskRequest.doProcess(): TaskDetailsResponse {
        val stageTask = taskDomainUseCaseFactory.findStageTaskByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(taskKey, false)
                    .process()
                    .response
            }
        val actions = stageTask.actions
            .map {
                it.viewIdentity()
            }
        return TaskDetailsResponse(stageTask.uuid, stageTask.taskKey, stageTask.taskName, actions)
    }

    private fun TaskActionIdentity.viewIdentity(): ViewIdentify {
        return ViewIdentify(uuid, actionKey)
    }
}