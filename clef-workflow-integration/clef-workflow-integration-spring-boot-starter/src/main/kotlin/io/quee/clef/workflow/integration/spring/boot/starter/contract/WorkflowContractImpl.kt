package io.quee.clef.workflow.integration.spring.boot.starter.contract

import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.workflow.WorkflowContract
import io.quee.clef.workflow.api.contract.workflow.dto.CreateWorkflowRequestDto
import io.quee.clef.workflow.api.contract.workflow.dto.WorkflowRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.FullWorkflowStructure
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowContractImpl(private val workflowUseCaseFactory: WorkflowUseCaseFactory) : WorkflowContract {
    override fun CreateWorkflowRequestDto.create(): ContractResponse<ViewIdentify> {
        return workflowUseCaseFactory.createWorkflowUseCase
                .run {
                    ContractResponse(this@create.process())
                }
    }

    override fun details(key: String, uuid: String): ContractResponse<WorkflowDetailsResponse> {
        return workflowUseCaseFactory.workflowDetailsUseCase
                .run {
                    ContractResponse(WorkflowRequestDto(key, uuid).process())
                }
    }

    override fun structure(): ContractResponse<FullWorkflowStructure> {
        return workflowUseCaseFactory.fullWorkflowStructureUseCase
                .run {
                    ContractResponse(UseCaseRequest.NOP.process())
                }
    }

    override fun enable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return workflowUseCaseFactory.enableWorkflowUseCase
                .run {
                    ContractResponse(WorkflowRequestDto(key, uuid).process())
                }
    }

    override fun disable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return workflowUseCaseFactory.disableWorkflowUseCase
                .run {
                    ContractResponse(WorkflowRequestDto(key, uuid).process())
                }
    }

    override fun delete(key: String, uuid: String): ContractResponse<SharedResponse> {
        return workflowUseCaseFactory.deleteWorkflowUseCase
                .run {
                    ContractResponse(WorkflowRequestDto(key, uuid).process())
                }
    }
}