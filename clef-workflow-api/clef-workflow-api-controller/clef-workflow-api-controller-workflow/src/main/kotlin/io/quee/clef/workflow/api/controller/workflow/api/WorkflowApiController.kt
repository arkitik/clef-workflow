package io.quee.clef.workflow.api.controller.workflow.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.controller.workflow.contract.WorkflowApiContract
import io.quee.clef.workflow.api.controller.workflow.dto.CreateWorkflowRequestDto
import io.quee.clef.workflow.api.controller.workflow.dto.WorkflowRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class WorkflowApiController(private val workflowUseCaseFactory: WorkflowUseCaseFactory) : WorkflowApiContract {
    override fun CreateWorkflowRequestDto.create(): ResponseEntity<ViewIdentify> {
        return workflowUseCaseFactory.createWorkflowUseCase
                .run {
                    ResponseEntity.ok(this@create.process())
                }
    }

    override fun details(key: String, uuid: String): ResponseEntity<WorkflowDetailsResponse> {
        return workflowUseCaseFactory.workflowDetailsUseCase
                .run {
                    ResponseEntity.ok(WorkflowRequestDto(key, uuid).process())
                }
    }

    override fun enable(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return workflowUseCaseFactory.enableWorkflowUseCase
                .run {
                    ResponseEntity.ok(WorkflowRequestDto(key, uuid).process())
                }
    }

    override fun disable(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return workflowUseCaseFactory.disableWorkflowUseCase
                .run {
                    ResponseEntity.ok(WorkflowRequestDto(key, uuid).process())
                }
    }

    override fun delete(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return workflowUseCaseFactory.deleteWorkflowUseCase
                .run {
                    ResponseEntity.ok(WorkflowRequestDto(key, uuid).process())
                }
    }
}