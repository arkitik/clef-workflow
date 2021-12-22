package io.arkitik.clef.workflow.api.usecase.workflow.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class WorkflowDetailsUseCase(
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : ValidationFunctionalUseCase<WorkflowRequest, WorkflowDetailsResponse>() {
    override fun WorkflowRequest.doProcess(): WorkflowDetailsResponse {
        val workflow = workflowDomainUseCaseFactory.findWorkflowByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(workflowKey, false)
                    .process()
                    .response
            }
        return WorkflowDetailsResponse(
            workflow.uuid,
            workflow.workflowKey,
            workflow.workflowName,
            workflow.workflowDescription,
            viewIdentify(workflow.initialStage),
            workflow.stages
                .map {
                    stageViewIdentity(it)
                }
        )
    }

    private fun viewIdentify(stage: StageIdentity?): ViewIdentify? = when {
        stage != null -> stageViewIdentity(stage)
        else -> null
    }

    private fun stageViewIdentity(stage: StageIdentity): ViewIdentify {
        return ViewIdentify(stage.uuid, stage.stageKey)
    }
}

