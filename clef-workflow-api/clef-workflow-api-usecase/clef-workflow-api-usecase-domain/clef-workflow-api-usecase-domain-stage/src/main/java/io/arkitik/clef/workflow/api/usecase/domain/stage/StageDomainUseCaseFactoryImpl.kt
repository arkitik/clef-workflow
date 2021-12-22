package io.arkitik.clef.workflow.api.usecase.domain.stage

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.usecase.domain.stage.main.*
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.AddTaskToStageRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageDomainUseCaseFactoryImpl(
    stageStore: StageStore,
    identityAccessValidation: IdentityAccessValidation,
    taskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
) : StageDomainUseCaseFactory {
    override val findStageByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<StageIdentity>> =
        FindStageByKeyAndUuidUseCase(stageStore.storeQuery)
    override val findStageByTaskUseCase: FunctionalUseCase<RequestAdapter<StageTaskIdentity>, ResponseAdapter<StageIdentity>> =
        FindStageByTaskUseCase(stageStore.storeQuery)
    override val validateStageExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
        ValidateStageExistenceUseCase(stageStore.storeQuery)
    override val addTaskToStageUseCase: CommandUseCase<AddTaskToStageRequest> =
        AddTaskToStageUseCase(stageStore, identityAccessValidation)
    override val deleteAllStagesUseCase: CommandUseCase<RequestAdapter<List<StageIdentity>>> =
        DeleteAllStagesUseCase(stageStore, taskDomainUseCaseFactory)
}