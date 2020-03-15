package io.quee.clef.workflow.api.usecase.workflow

import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse
import io.quee.clef.workflow.api.usecase.workflow.main.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowUseCaseFactoryImpl(
        workflowStore: WorkflowStore,
        identityStatusValidation: IdentityStatusValidation
) : WorkflowUseCaseFactory {
    override val createWorkflowUseCase: FunctionalUseCase<CreateWorkflowRequest, ViewIdentify> = CreateWorkflowUseCase(workflowStore)

    override val workflowDetailsUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, WorkflowDetailsResponse> = WorkflowDetailsUseCase(workflowStore.storeQuery)

    override val activateWorkflowUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, SharedResponse> = ActivateWorkflowUseCase(workflowStore, identityStatusValidation)

    override val deactivateWorkflowUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, SharedResponse> = DisableWorkflowUseCase(workflowStore, identityStatusValidation)

    override val deleteWorkflowUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, SharedResponse> = DeleteWorkflowUseCase(workflowStore, identityStatusValidation)
}