package io.arkitik.clef.workflow.api.usecase.factory.workflow

import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionUseCaseFactory : UseCaseFactory {
    val createActionUseCase: FunctionalUseCase<CreateTaskActionRequest, ViewIdentify>
    val actionDetailsUseCase: FunctionalUseCase<TaskActionRequest, TaskActionDetails>
    val enableActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse>
    val disableActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse>
    val deleteActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse>
}
