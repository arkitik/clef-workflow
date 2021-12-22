package io.arkitik.clef.workflow.api.usecase.domain.task

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.store.task.StageTaskStore
import io.arkitik.clef.workflow.api.usecase.domain.task.main.AddActionToTaskUseCase
import io.arkitik.clef.workflow.api.usecase.domain.task.main.DeleteAllTasksUseCase
import io.arkitik.clef.workflow.api.usecase.domain.task.main.FindStageByKeyAndUuidUseCase
import io.arkitik.clef.workflow.api.usecase.domain.task.main.ValidateStageTaskExistenceUseCase
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.AddActionToTaskRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageTaskDomainUseCaseFactoryImpl(
    stageTaskStore: StageTaskStore,
    identityAccessValidation: IdentityAccessValidation,
    actionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
) : StageTaskDomainUseCaseFactory {
    override val findStageTaskByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<StageTaskIdentity>> =
        FindStageByKeyAndUuidUseCase(stageTaskStore.storeQuery)
    override val validateStageTaskExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
        ValidateStageTaskExistenceUseCase(stageTaskStore.storeQuery)
    override val addActionToTaskUseCase: CommandUseCase<AddActionToTaskRequest> =
        AddActionToTaskUseCase(stageTaskStore, identityAccessValidation)
    override val deleteAllTasksUseCase: CommandUseCase<RequestAdapter<List<StageTaskIdentity>>> =
        DeleteAllTasksUseCase(stageTaskStore, actionDomainUseCaseFactory)
}