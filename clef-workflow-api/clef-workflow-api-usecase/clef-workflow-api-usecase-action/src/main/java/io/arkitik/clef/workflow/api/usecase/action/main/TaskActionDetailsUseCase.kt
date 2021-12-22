package io.arkitik.clef.workflow.api.usecase.action.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionParameter
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionParamDetails

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskActionDetailsUseCase(
    private val taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskActionRequest, TaskActionDetails>() {

    override fun TaskActionRequest.doProcess(): TaskActionDetails {
        val taskAction = taskActionDomainUseCaseFactory.findTaskActionByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(actionKey, false)
                    .process()
                    .response
            }

        return TaskActionDetails(
            taskAction.uuid,
            taskAction.actionKey,
            taskAction.actionName,
            taskAction.actionDescription,
            taskAction.destinationTask.stageViewIdentity(),
            taskAction.parameters.map {
                it.parameterView()
            }
        )
    }

    private fun StageTaskIdentity.stageViewIdentity(): ViewIdentify {
        return ViewIdentify(uuid, taskKey)
    }

    private fun TaskActionParameter.parameterView(): TaskActionParamDetails {
        return TaskActionParamDetails(parameterKey, parameterValue)
    }
}