package io.quee.clef.workflow.api.usecase.domain.workflow

import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.api.develop.usecase.type.CommandUseCase
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.domain.workflow.main.AddStageToWorkflowUseCase
import io.quee.clef.workflow.api.usecase.domain.workflow.main.DeleteAllWorkflowUseCase
import io.quee.clef.workflow.api.usecase.domain.workflow.main.FindWorkflowByKeyAndUuidUseCase
import io.quee.clef.workflow.api.usecase.domain.workflow.main.ValidateWorkflowExistenceUseCase
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddStageToWorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowDomainUseCaseFactoryImpl(
        workflowStore: WorkflowStore,
        identityAccessValidation: IdentityAccessValidation,
        stageDomainUseCaseFactory: StageDomainUseCaseFactory
) : WorkflowDomainUseCaseFactory {
    override val findWorkflowByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<WorkflowIdentity>> =
            FindWorkflowByKeyAndUuidUseCase(workflowStore.storeQuery)
    override val validateWorkflowExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
            ValidateWorkflowExistenceUseCase(workflowStore.storeQuery)
    override val addStageToWorkflowUseCase: CommandUseCase<AddStageToWorkflowRequest> =
            AddStageToWorkflowUseCase(workflowStore, identityAccessValidation)
    override val deleteAllWorkflowUseCase: CommandUseCase<RequestAdapter<List<WorkflowIdentity>>> =
            DeleteAllWorkflowUseCase(workflowStore, stageDomainUseCaseFactory)
}