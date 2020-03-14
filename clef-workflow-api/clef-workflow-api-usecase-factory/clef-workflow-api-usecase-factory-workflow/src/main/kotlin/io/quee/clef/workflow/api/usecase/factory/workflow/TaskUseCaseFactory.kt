package io.quee.clef.workflow.api.usecase.factory.workflow

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface TaskUseCaseFactory : UseCaseFactory {
    val createTaskUseCase: FunctionalUseCase<CreateTaskRequest, ViewIdentify>
    val taskDetailsUseCase: FunctionalUseCase<TaskRequest<UseCaseRequest>, TaskDetailsResponse>
    val activateTaskUseCase: FunctionalUseCase<TaskRequest<UseCaseRequest>, SharedResponse>
    val deactivateTaskUseCase: FunctionalUseCase<TaskRequest<UseCaseRequest>, SharedResponse>
    val deleteTaskUseCase: FunctionalUseCase<TaskRequest<UseCaseRequest>, SharedResponse>
}