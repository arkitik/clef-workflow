package io.arkitik.clef.workflow.api.usecase.factory.domain

import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.AddStageToWorkflowRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface WorkflowDomainUseCaseFactory : UseCaseFactory {
    val findWorkflowByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<WorkflowIdentity>>
    val findWorkflowByStageUseCase: FunctionalUseCase<RequestAdapter<StageIdentity>, ResponseAdapter<WorkflowIdentity>>
    val validateWorkflowExistenceUseCase: CommandUseCase<ExistByKeyRequest>
    val addStageToWorkflowUseCase: CommandUseCase<AddStageToWorkflowRequest>
    val deleteAllWorkflowUseCase: CommandUseCase<RequestAdapter<List<WorkflowIdentity>>>
}