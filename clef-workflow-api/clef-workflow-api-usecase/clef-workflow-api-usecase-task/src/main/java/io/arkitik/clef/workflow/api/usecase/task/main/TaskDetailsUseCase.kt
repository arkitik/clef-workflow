package io.arkitik.clef.workflow.api.usecase.task.main

import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.task.TaskDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskDetailsUseCase(
    private val taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
    private val actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskRequest, TaskDetailsResponse>() {
    override fun TaskRequest.doProcess(): TaskDetailsResponse {
        val task = taskDomainUseCaseFactory.functional {
            findTaskByKeyUseCase
        }.process(FindDomainByKeyRequest(taskKey, false)).response
        val response = actionDomainUseCaseFactory.functional {
            findTaskActionsUseCase
        }.process(TaskDomainRequest(task))
        val actions = response.actions
            .map {
                it.viewIdentity()
            }
        return TaskDetailsResponse(task.uuid, task.taskKey, task.taskName, actions)
    }

    private fun ActionIdentity.viewIdentity(): ViewIdentify {
        return ViewIdentify(uuid, actionKey)
    }
}
