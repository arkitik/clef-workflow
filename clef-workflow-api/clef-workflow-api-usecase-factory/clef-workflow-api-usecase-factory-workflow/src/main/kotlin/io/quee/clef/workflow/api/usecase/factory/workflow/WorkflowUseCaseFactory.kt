package io.quee.clef.workflow.api.usecase.factory.workflow

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.type.CommandUseCase
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.CreateWorkflowResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface WorkflowUseCaseFactory : UseCaseFactory {
    val createWorkflowUseCase: FunctionalUseCase<WorkflowRequest<CreateWorkflowRequest>, CreateWorkflowResponse>
    val workflowDetailsUseCase: FunctionalUseCase<WorkflowRequest<UseCaseRequest>, WorkflowDetailsResponse>
    val activateWorkflowUseCase: CommandUseCase<WorkflowRequest<UseCaseRequest>>
    val deactivateWorkflowUseCase: CommandUseCase<WorkflowRequest<UseCaseRequest>>
    val deleteWorkflowUseCase: CommandUseCase<WorkflowRequest<UseCaseRequest>>
}