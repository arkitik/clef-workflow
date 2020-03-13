package io.quee.clef.workflow.api.usecase.factory.workflow

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.type.CommandUseCase
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface TaskActionUseCaseFactory : UseCaseFactory {
    val createTaskActionUseCase: FunctionalUseCase<CreateTaskRequest, ViewIdentify>
    val activateTaskActionUseCase: CommandUseCase<TaskRequest<UseCaseRequest>>
    val deactivateTaskActionUseCase: CommandUseCase<TaskRequest<UseCaseRequest>>
    val deleteTaskActionUseCase: CommandUseCase<TaskRequest<UseCaseRequest>>
}