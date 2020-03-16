package io.quee.clef.workflow.api.usecase.stage

import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.stage.StageStore
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse
import io.quee.clef.workflow.api.usecase.stage.main.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageUseCaseFactoryImpl(
        stageStore: StageStore,
        stageDomainUseCaseFactory: StageDomainUseCaseFactory,
        identityStatusValidation: IdentityStatusValidation,
        workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory
) : StageUseCaseFactory {
    override val createStageUseCase: FunctionalUseCase<CreateStageRequest, ViewIdentify> = CreateStageUseCase(stageStore.identityCreator(), stageDomainUseCaseFactory, workflowDomainUseCaseFactory)
    override val stageDetailsUseCase: FunctionalUseCase<StageRequest, StageDetailsResponse> = StageDetailsUseCase(stageDomainUseCaseFactory)
    override val enableStageUseCase: FunctionalUseCase<StageRequest, SharedResponse> = EnableStageUseCase(stageStore, identityStatusValidation, stageDomainUseCaseFactory)
    override val disableStageUseCase: FunctionalUseCase<StageRequest, SharedResponse> = DisableStageUseCase(stageStore, identityStatusValidation, stageDomainUseCaseFactory)
    override val deleteStageUseCase: FunctionalUseCase<StageRequest, SharedResponse> = DeleteStageUseCase(stageStore, identityStatusValidation, stageDomainUseCaseFactory)
}