package io.quee.clef.workflow.api.usecase.factory.workflow

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface WorkflowUseCaseFactory : UseCaseFactory {
    val createWorkflowUseCase: FunctionalUseCase<CreateWorkflowRequest, ViewIdentify>
    val workflowDetailsUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, WorkflowDetailsResponse>
    val activateWorkflowUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, SharedResponse>
    val deactivateWorkflowUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, SharedResponse>
    val deleteWorkflowUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, SharedResponse>
}