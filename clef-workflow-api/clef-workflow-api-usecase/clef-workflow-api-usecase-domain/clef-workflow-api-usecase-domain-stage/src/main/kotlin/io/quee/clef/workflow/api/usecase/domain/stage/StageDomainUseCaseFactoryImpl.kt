package io.quee.clef.workflow.api.usecase.domain.stage

import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.api.develop.usecase.type.CommandUseCase
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.stage.StageStore
import io.quee.clef.workflow.api.usecase.domain.stage.main.*
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddTaskToStageRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageDomainUseCaseFactoryImpl(
        stageStore: StageStore,
        identityAccessValidation: IdentityAccessValidation,
        taskDomainUseCaseFactory: StageTaskDomainUseCaseFactory
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