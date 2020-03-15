package io.quee.clef.workflow.api.usecase.factory.workflow

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface TaskUseCaseFactory : UseCaseFactory {
    val createTaskUseCase: FunctionalUseCase<CreateTaskRequest, ViewIdentify>
    val taskDetailsUseCase: FunctionalUseCase<TaskRequest, TaskDetailsResponse>
    val activateTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse>
    val deactivateTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse>
    val deleteTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse>
}