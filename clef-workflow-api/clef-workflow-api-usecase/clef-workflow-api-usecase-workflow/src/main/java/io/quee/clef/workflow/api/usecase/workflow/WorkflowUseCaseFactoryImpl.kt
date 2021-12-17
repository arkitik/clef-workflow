package io.quee.clef.workflow.api.usecase.workflow

import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.quee.clef.workflow.api.usecase.workflow.main.*
import io.quee.clef.workflow.api.usecase.workflow.structure.FullWorkflowStructureUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowUseCaseFactoryImpl(
    workflowStore: WorkflowStore,
    identityStatusValidation: IdentityStatusValidation,
    workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : WorkflowUseCaseFactory {
    override val createWorkflowUseCase =
        CreateWorkflowUseCase(
            workflowStore,
            workflowDomainUseCaseFactory
        )

    override val workflowDetailsUseCase =
        WorkflowDetailsUseCase(workflowDomainUseCaseFactory)

    override val enableWorkflowUseCase =
        EnableWorkflowUseCase(
            workflowStore,
            identityStatusValidation,
            workflowDomainUseCaseFactory
        )

    override val disableWorkflowUseCase =
        DisableWorkflowUseCase(
            workflowStore,
            identityStatusValidation,
            workflowDomainUseCaseFactory
        )

    override val deleteWorkflowUseCase =
        DeleteWorkflowUseCase(
            identityStatusValidation,
            workflowDomainUseCaseFactory
        )
    override val fullWorkflowStructureUseCase =
        FullWorkflowStructureUseCase(workflowStore.storeQuery)
}