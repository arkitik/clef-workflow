package io.arkitik.clef.workflow.api.usecase.domain.action

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.store.action.TaskActionStore
import io.arkitik.clef.workflow.api.usecase.domain.action.main.DeleteAllActionsUseCase
import io.arkitik.clef.workflow.api.usecase.domain.action.main.FindTaskActionByKeyAndUuidUseCase
import io.arkitik.clef.workflow.api.usecase.domain.action.main.ValidateTaskActionExistenceUseCase
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskActionDomainUseCaseFactoryImpl(
    taskActionStore: TaskActionStore,
) : TaskActionDomainUseCaseFactory {
    override val findTaskActionByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<TaskActionIdentity>> =
        FindTaskActionByKeyAndUuidUseCase(taskActionStore.storeQuery)
    override val validateTaskActionExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
        ValidateTaskActionExistenceUseCase(taskActionStore.storeQuery)
    override val deleteAllActionsUseCase: CommandUseCase<RequestAdapter<List<TaskActionIdentity>>> =
        DeleteAllActionsUseCase(taskActionStore)
}