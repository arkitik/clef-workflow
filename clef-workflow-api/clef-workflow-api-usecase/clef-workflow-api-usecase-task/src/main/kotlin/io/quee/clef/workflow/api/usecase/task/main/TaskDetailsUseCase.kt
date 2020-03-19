package io.quee.clef.workflow.api.usecase.task.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskDetailsUseCase(private val taskDomainUseCaseFactory: StageTaskDomainUseCaseFactory) : ValidationFunctionalUseCase<TaskRequest, TaskDetailsResponse>() {
    override fun TaskRequest.realProcess(): TaskDetailsResponse {
        val stageTask = taskDomainUseCaseFactory.findStageTaskByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(taskKey, taskUuid)
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