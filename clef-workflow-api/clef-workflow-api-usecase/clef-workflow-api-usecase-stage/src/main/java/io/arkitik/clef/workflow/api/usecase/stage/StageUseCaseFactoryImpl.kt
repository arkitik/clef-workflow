package io.arkitik.clef.workflow.api.usecase.stage

import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse
import io.arkitik.clef.workflow.api.usecase.stage.main.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageUseCaseFactoryImpl(
    stageStore: StageStore,
    stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    identityStatusValidation: IdentityStatusValidation,
    workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : StageUseCaseFactory {
    override val createStageUseCase: FunctionalUseCase<CreateStageRequest, ViewIdentify> =
        CreateStageUseCase(stageStore.identityCreator(), stageDomainUseCaseFactory, workflowDomainUseCaseFactory)
    override val stageDetailsUseCase: FunctionalUseCase<StageRequest, StageDetailsResponse> =
        StageDetailsUseCase(stageDomainUseCaseFactory)
    override val enableStageUseCase: FunctionalUseCase<StageRequest, SharedResponse> =
        EnableStageUseCase(stageStore, identityStatusValidation, stageDomainUseCaseFactory)
    override val disableStageUseCase: FunctionalUseCase<StageRequest, SharedResponse> =
        DisableStageUseCase(stageStore, identityStatusValidation, stageDomainUseCaseFactory)
    override val deleteStageUseCase: FunctionalUseCase<StageRequest, SharedResponse> =
        DeleteStageUseCase(identityStatusValidation, stageDomainUseCaseFactory)
}