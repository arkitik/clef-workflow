package io.quee.clef.workflow.api.usecase.workflow.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.WorkflowDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class WorkflowDetailsUseCase(private val workflowStoreQuery: WorkflowStoreQuery) : ValidationFunctionalUseCase<WorkflowRequest<UseCaseRequest>, WorkflowDetailsResponse>() {
    override fun WorkflowRequest<UseCaseRequest>.realProcess(): WorkflowDetailsResponse {
        val workflow = workflowStoreQuery.findByKeyAndUuid(workflowKey, workflowUuid)
        if (workflow != null) {
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
        throw NotAcceptableException(WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
    }

    private fun viewIdentify(stage: StageIdentity?): ViewIdentify? = when {
        stage != null -> stageViewIdentity(stage)
        else -> null
    }

    private fun stageViewIdentity(stage: StageIdentity): ViewIdentify {
        return ViewIdentify(stage.uuid, stage.stageKey)
    }
}

