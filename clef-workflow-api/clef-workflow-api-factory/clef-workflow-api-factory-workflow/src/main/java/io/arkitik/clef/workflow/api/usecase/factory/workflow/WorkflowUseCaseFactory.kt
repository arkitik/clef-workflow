package io.arkitik.clef.workflow.api.usecase.factory.workflow

import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.FullWorkflowStructure
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface WorkflowUseCaseFactory : UseCaseFactory {
    val createWorkflowUseCase: FunctionalUseCase<CreateWorkflowRequest, ViewIdentify>
    val workflowDetailsUseCase: FunctionalUseCase<WorkflowRequest, WorkflowDetailsResponse>
    val enableWorkflowUseCase: FunctionalUseCase<WorkflowRequest, SharedResponse>
    val disableWorkflowUseCase: FunctionalUseCase<WorkflowRequest, SharedResponse>
    val deleteWorkflowUseCase: FunctionalUseCase<WorkflowRequest, SharedResponse>

    val fullWorkflowStructureUseCase: FunctionalUseCase<UseCaseRequest, FullWorkflowStructure>
}