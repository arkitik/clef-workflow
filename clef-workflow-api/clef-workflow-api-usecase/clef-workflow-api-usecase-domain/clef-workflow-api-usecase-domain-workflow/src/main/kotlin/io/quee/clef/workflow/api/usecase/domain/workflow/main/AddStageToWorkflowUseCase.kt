package io.quee.clef.workflow.api.usecase.domain.workflow.main

import io.quee.api.develop.action.usecase.validation.ValidationCommandUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddStageToWorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class AddStageToWorkflowUseCase(
        private val workflowStore: WorkflowStore,
        private val identityAccessValidation: IdentityAccessValidation
) : ValidationCommandUseCase<AddStageToWorkflowRequest>() {
    override fun AddStageToWorkflowRequest.extraValidation() {
        identityAccessValidation.run {
            workflow.identityStatus.validate()
        }
        if (workflow.initialStage != null) {
            throw NotAcceptableException(WorkflowResponses.Errors.INITIAL_STAGE_HAS_BEEN_ADDED_BEFORE)
        }
    }

    override fun AddStageToWorkflowRequest.realExecute() {
        workflowStore.run {
            val updater = workflow.identityUpdater()
            updater.run {
                if (initialStage) {
                    stage.initialStage()
                } else {
                    stage.addStage()
                }
                updater.update().save()
            }
        }
    }
}