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
interface TaskUseCaseFactory : UseCaseFactory {
    val createTaskUseCase: FunctionalUseCase<CreateTaskRequest, ViewIdentify>
    val activateTaskUseCase: CommandUseCase<TaskRequest<UseCaseRequest>>
    val deactivateTaskUseCase: CommandUseCase<TaskRequest<UseCaseRequest>>
    val deleteTaskUseCase: CommandUseCase<TaskRequest<UseCaseRequest>>
}