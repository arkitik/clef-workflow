package io.arkitik.clef.workflow.api.usecase.workflow

import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.workflow.WorkflowStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.workflow.main.*
import io.arkitik.clef.workflow.api.usecase.workflow.structure.FullWorkflowStructureUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class WorkflowUseCaseFactoryImpl(
    workflowStore: WorkflowStore,
    identityStatusValidation: IdentityStatusValidation,
    workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
    stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
    actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
) : WorkflowUseCaseFactory {
    override val createWorkflowUseCase =
        CreateWorkflowUseCase(
            workflowStore = workflowStore,
            workflowDomainUseCaseFactory = workflowDomainUseCaseFactory
        )

    override val workflowDetailsUseCase =
        WorkflowDetailsUseCase(
            workflowDomainUseCaseFactory = workflowDomainUseCaseFactory,
            stageDomainUseCaseFactory = stageDomainUseCaseFactory,
        )

    override val enableWorkflowUseCase =
        EnableWorkflowUseCase(
            workflowStore = workflowStore,
            identityStatusValidation = identityStatusValidation,
            workflowDomainUseCaseFactory = workflowDomainUseCaseFactory
        )

    override val disableWorkflowUseCase =
        DisableWorkflowUseCase(
            workflowStore = workflowStore,
            identityStatusValidation = identityStatusValidation,
            workflowDomainUseCaseFactory = workflowDomainUseCaseFactory
        )

    override val deleteWorkflowUseCase =
        DeleteWorkflowUseCase(
            workflowStore = workflowStore,
            identityStatusValidation = identityStatusValidation,
            workflowDomainUseCaseFactory = workflowDomainUseCaseFactory
        )
    override val fullWorkflowStructureUseCase =
        FullWorkflowStructureUseCase(
            workflowStoreQuery = workflowStore.storeQuery,
            stageDomainUseCaseFactory = stageDomainUseCaseFactory,
            taskDomainUseCaseFactory = taskDomainUseCaseFactory,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory,
        )
}
