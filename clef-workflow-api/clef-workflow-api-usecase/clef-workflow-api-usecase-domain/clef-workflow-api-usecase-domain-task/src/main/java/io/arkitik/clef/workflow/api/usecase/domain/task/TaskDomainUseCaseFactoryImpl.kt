package io.arkitik.clef.workflow.api.usecase.domain.task

import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.store.task.InitialTaskStore
import io.arkitik.clef.workflow.api.store.task.TaskStore
import io.arkitik.clef.workflow.api.usecase.domain.task.main.FindStageInitialTaskUseCase
import io.arkitik.clef.workflow.api.usecase.domain.task.main.FindStageTaskByKeyAndUuidUseCase
import io.arkitik.clef.workflow.api.usecase.domain.task.main.FindStageTasksUseCase
import io.arkitik.clef.workflow.api.usecase.domain.task.main.ValidateStageTaskExistenceUseCase
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskDomainUseCaseFactoryImpl(
    taskStore: TaskStore,
    initialTaskStore: InitialTaskStore,
) : TaskDomainUseCaseFactory {
    override val findTaskByKeyUseCase: FunctionalUseCase<FindDomainByKeyRequest, ResponseAdapter<TaskIdentity>> =
        FindStageTaskByKeyAndUuidUseCase(taskStore.storeQuery)
    override val validateTaskExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
        ValidateStageTaskExistenceUseCase(taskStore.storeQuery)
    override val findStageTasksUseCase =
        FindStageTasksUseCase(
            taskStore.storeQuery,
            initialTaskStore.storeQuery
        )
    override val findStageInitialTaskUseCase =
        FindStageInitialTaskUseCase(initialTaskStore.storeQuery)
}
