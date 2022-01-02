package io.arkitik.clef.workflow.api.usecase.domain.workflow

import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.store.workflow.WorkflowStore
import io.arkitik.clef.workflow.api.usecase.domain.workflow.main.FindWorkflowByKeyUseCase
import io.arkitik.clef.workflow.api.usecase.domain.workflow.main.ValidateWorkflowExistenceUseCase
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class WorkflowDomainUseCaseFactoryImpl(
    workflowStore: WorkflowStore,
) : WorkflowDomainUseCaseFactory {
    override val findWorkflowByKeyUseCase: FunctionalUseCase<FindDomainByKeyRequest, ResponseAdapter<WorkflowIdentity>> =
        FindWorkflowByKeyUseCase(workflowStore.storeQuery)
    override val validateWorkflowExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
        ValidateWorkflowExistenceUseCase(workflowStore.storeQuery)
}
