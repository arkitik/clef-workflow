package io.arkitik.clef.workflow.api.usecase.factory.workflow

import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageUseCaseFactory : UseCaseFactory {
    val createStageUseCase: FunctionalUseCase<CreateStageRequest, ViewIdentify>
    val stageDetailsUseCase: FunctionalUseCase<StageRequest, StageDetailsResponse>
    val enableStageUseCase: FunctionalUseCase<StageRequest, SharedResponse>
    val disableStageUseCase: FunctionalUseCase<StageRequest, SharedResponse>
    val deleteStageUseCase: FunctionalUseCase<StageRequest, SharedResponse>
}