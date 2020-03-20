package io.quee.clef.workflow.api.usecase.workflow.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateWorkflowUseCase(
        private val workflowStore: WorkflowStore,
        private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory
) : ValidationFunctionalUseCase<CreateWorkflowRequest, ViewIdentify>() {
    override fun CreateWorkflowRequest.extraValidation() {
        workflowDomainUseCaseFactory.validateWorkflowExistenceUseCase
                .run {
                    ExistByKeyRequest.instance(workflowKey)
                            .execute()
                }
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