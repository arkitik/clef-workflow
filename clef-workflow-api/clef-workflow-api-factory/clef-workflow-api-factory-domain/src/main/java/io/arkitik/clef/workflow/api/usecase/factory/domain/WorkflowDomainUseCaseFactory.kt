package io.arkitik.clef.workflow.api.usecase.factory.domain

import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface WorkflowDomainUseCaseFactory : UseCaseFactory {
    val findWorkflowByKeyUseCase: FunctionalUseCase<FindDomainByKeyRequest, ResponseAdapter<WorkflowIdentity>>
    val validateWorkflowExistenceUseCase: CommandUseCase<ExistByKeyRequest>
}
