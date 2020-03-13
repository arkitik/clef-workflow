package io.quee.clef.workflow.api.usecase.factory.workflow

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.CreateStageTaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.CreateStageTaskResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface StageTaskUseCaseFactory : UseCaseFactory {
    val createStageTaskUseCase: FunctionalUseCase<CreateStageTaskRequest, CreateStageTaskResponse>
}