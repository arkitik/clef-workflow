package io.arkitik.clef.workflow.api.usecase.workflow.main

import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.workflow.WorkflowDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class WorkflowDetailsUseCase(
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
) : ValidationFunctionalUseCase<WorkflowRequest, WorkflowDetailsResponse>() {
    override fun WorkflowRequest.doProcess(): WorkflowDetailsResponse {
        val workflow = workflowDomainUseCaseFactory.functional {
            findWorkflowByKeyUseCase
        }.process(FindDomainByKeyRequest(workflowKey, false)).response

        val response = stageDomainUseCaseFactory.functional {
            findWorkflowStagesUseCase
        }.process(WorkflowDomainRequest(workflow))
        return WorkflowDetailsResponse(
            workflow.uuid,
            workflow.workflowKey,
            workflow.workflowName,
            workflow.workflowDescription,
            response.initialStage?.stageViewIdentity(),
            response.stages
                .map {
                    it.stageViewIdentity()
                }
        )
    }

    private fun StageIdentity.stageViewIdentity(): ViewIdentify {
        return ViewIdentify(uuid, stageKey)
    }
}

