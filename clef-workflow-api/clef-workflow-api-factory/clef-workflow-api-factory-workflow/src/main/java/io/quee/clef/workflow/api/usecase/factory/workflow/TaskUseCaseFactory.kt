package io.quee.clef.workflow.api.usecase.factory.workflow

import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
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
    val enableTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse>
    val disableTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse>
    val deleteTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse>
}