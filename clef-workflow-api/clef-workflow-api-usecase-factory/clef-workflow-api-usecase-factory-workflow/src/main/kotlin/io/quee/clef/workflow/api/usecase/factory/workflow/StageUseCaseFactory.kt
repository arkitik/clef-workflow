package io.quee.clef.workflow.api.usecase.factory.workflow

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface StageUseCaseFactory : UseCaseFactory {
    val createStageUseCase: FunctionalUseCase<CreateStageRequest, ViewIdentify>
    val stageDetailsUseCase: FunctionalUseCase<StageRequest<UseCaseRequest>, StageDetailsResponse>
    val activateStageUseCase: FunctionalUseCase<StageRequest<UseCaseRequest>, SharedResponse>
    val deactivateStageUseCase: FunctionalUseCase<StageRequest<UseCaseRequest>, SharedResponse>
    val deleteStageUseCase: FunctionalUseCase<StageRequest<UseCaseRequest>, SharedResponse>
}