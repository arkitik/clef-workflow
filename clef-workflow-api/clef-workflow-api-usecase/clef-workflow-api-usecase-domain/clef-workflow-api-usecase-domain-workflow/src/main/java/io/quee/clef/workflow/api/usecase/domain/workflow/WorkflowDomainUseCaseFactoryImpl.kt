package io.quee.clef.workflow.api.usecase.domain.workflow

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.domain.workflow.main.*
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
    stageDomainUseCaseFactory: StageDomainUseCaseFactory,
) : WorkflowDomainUseCaseFactory {
    override val findWorkflowByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<WorkflowIdentity>> =
        FindWorkflowByKeyAndUuidUseCase(workflowStore.storeQuery)
    override val findWorkflowByStageUseCase: FunctionalUseCase<RequestAdapter<StageIdentity>, ResponseAdapter<WorkflowIdentity>> =
        FindWorkflowByStageUseCase(workflowStore.storeQuery)
    override val validateWorkflowExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
        ValidateWorkflowExistenceUseCase(workflowStore.storeQuery)
    override val addStageToWorkflowUseCase: CommandUseCase<AddStageToWorkflowRequest> =
        AddStageToWorkflowUseCase(workflowStore, identityAccessValidation)
    override val deleteAllWorkflowUseCase: CommandUseCase<RequestAdapter<List<WorkflowIdentity>>> =
        DeleteAllWorkflowUseCase(workflowStore, stageDomainUseCaseFactory)
}