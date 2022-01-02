package io.arkitik.clef.workflow.api.usecase.task

import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.task.InitialTaskStore
import io.arkitik.clef.workflow.api.store.task.TaskStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.task.main.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskUseCaseFactoryImpl(
    taskStore: TaskStore,
    initialTaskStore: InitialTaskStore,
    taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
    identityStatusValidation: IdentityStatusValidation,
    stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
) : TaskUseCaseFactory {

    override val createTaskUseCase =
        CreateTaskUseCase(
            taskStore = taskStore,
            initialTaskStore = initialTaskStore,
            taskDomainUseCaseFactory = taskDomainUseCaseFactory,
            stageDomainUseCaseFactory = stageDomainUseCaseFactory
        )

    override val taskDetailsUseCase =
        TaskDetailsUseCase(
            taskDomainUseCaseFactory = taskDomainUseCaseFactory,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory
        )

    override val enableTaskUseCase =
        EnableTaskUseCase(
            taskStore = taskStore,
            identityStatusValidation = identityStatusValidation,
            taskDomainUseCaseFactory = taskDomainUseCaseFactory
        )

    override val disableTaskUseCase =
        DisableTaskUseCase(
            taskStore = taskStore,
            identityStatusValidation = identityStatusValidation,
            taskDomainUseCaseFactory = taskDomainUseCaseFactory
        )

    override val deleteTaskUseCase =
        DeleteTaskUseCase(
            taskStore = taskStore,
            identityStatusValidation = identityStatusValidation,
            taskDomainUseCaseFactory = taskDomainUseCaseFactory)
}
