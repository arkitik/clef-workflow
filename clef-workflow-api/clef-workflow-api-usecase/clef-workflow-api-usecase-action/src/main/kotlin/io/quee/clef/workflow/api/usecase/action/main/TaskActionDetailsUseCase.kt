package io.quee.clef.workflow.api.usecase.action.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionDetailsUseCase(private val taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory) : ValidationFunctionalUseCase<TaskActionRequest, TaskActionDetails>() {
    override fun TaskActionRequest.realProcess(): TaskActionDetails {
        val taskAction = taskActionDomainUseCaseFactory.findTaskActionByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(actionKey, actionUuid)
                            .process()
                            .response
                }
        return TaskActionDetails(
                taskAction.uuid,
                taskAction.actionKey,
                taskAction.actionName,
                taskAction.actionDescription,
                stageViewIdentity(taskAction.destinationTask)
        )
    }

    private fun stageViewIdentity(stage: StageTaskIdentity): ViewIdentify {
        return ViewIdentify(stage.uuid, stage.taskKey)
    }
}