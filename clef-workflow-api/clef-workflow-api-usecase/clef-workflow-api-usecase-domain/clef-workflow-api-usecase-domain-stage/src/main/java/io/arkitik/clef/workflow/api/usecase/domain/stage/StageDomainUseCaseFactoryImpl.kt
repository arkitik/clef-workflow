package io.arkitik.clef.workflow.api.usecase.domain.stage

import io.arkitik.clef.workflow.api.store.stage.InitialStageStore
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.usecase.domain.stage.main.FindStageByKeyUseCase
import io.arkitik.clef.workflow.api.usecase.domain.stage.main.FindWorkflowInitialStageUseCase
import io.arkitik.clef.workflow.api.usecase.domain.stage.main.FindWorkflowStagesUseCase
import io.arkitik.clef.workflow.api.usecase.domain.stage.main.ValidateStageExistenceUseCase
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageDomainUseCaseFactoryImpl(
    stageStore: StageStore,
    initialStageStore: InitialStageStore,
) : StageDomainUseCaseFactory {
    override val findStageByKeyUseCase =
        FindStageByKeyUseCase(stageStore.storeQuery)
    override val validateStageExistenceUseCase =
        ValidateStageExistenceUseCase(stageStore.storeQuery)
    override val findWorkflowStagesUseCase =
        FindWorkflowStagesUseCase(
            stageStoreQuery = stageStore.storeQuery,
            initialStageStoreQuery = initialStageStore.storeQuery
        )
    override val findWorkflowInitialStageUseCase =
        FindWorkflowInitialStageUseCase(initialStageStore.storeQuery)
}
