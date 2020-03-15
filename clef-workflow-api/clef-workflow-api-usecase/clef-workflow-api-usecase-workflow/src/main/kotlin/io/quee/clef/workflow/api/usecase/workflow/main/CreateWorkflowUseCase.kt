package io.quee.clef.workflow.api.usecase.workflow.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateWorkflowUseCase(private val workflowStore: WorkflowStore) : ValidationFunctionalUseCase<CreateWorkflowRequest, ViewIdentify>() {
    override fun CreateWorkflowRequest.extraValidation() {
        if (workflowStore.storeQuery.existByKey(workflowKey))
            throw NotAcceptableException(WorkflowResponses.Errors.DUPLICATE_WORKFLOW_ERROR)
    }

    override fun CreateWorkflowRequest.realProcess(): ViewIdentify {
        val workflow = workflowStore.run {
            identityCreator()
                    .run {
                        workflowDescription.workflowDescription()
                        workflowKey.workflowKey()
                        workflowName.workflowName()
                        create().save()
                    }
        }
        return ViewIdentify(workflow.uuid, workflow.workflowKey)
    }
}