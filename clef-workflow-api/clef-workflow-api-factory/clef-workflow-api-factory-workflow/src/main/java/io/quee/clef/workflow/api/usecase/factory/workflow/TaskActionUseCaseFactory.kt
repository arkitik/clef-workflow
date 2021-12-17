package io.quee.clef.workflow.api.usecase.factory.workflow

import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface TaskActionUseCaseFactory : UseCaseFactory {
    val createTaskActionUseCase: FunctionalUseCase<CreateTaskActionRequest, ViewIdentify>
    val taskActionDetailsUseCase: FunctionalUseCase<TaskActionRequest, TaskActionDetails>
    val enableTaskActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse>
    val disableTaskActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse>
    val deleteTaskActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse>
}