package io.arkitik.clef.workflow.api.usecase.workflow.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.store.workflow.WorkflowStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class CreateWorkflowUseCase(
    private val workflowStore: WorkflowStore,
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : ValidationFunctionalUseCase<CreateWorkflowRequest, ViewIdentify>() {
    override fun CreateWorkflowRequest.doBefore() {
        workflowDomainUseCaseFactory.validateWorkflowExistenceUseCase
            .run {
                ExistByKeyRequest(workflowKey)
                    .execute()
            }
    }

    override fun CreateWorkflowRequest.doProcess(): ViewIdentify {
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