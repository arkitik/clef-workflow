package io.arkitik.clef.workflow.api.usecase.workflow.main

import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.store.workflow.WorkflowStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest
import io.arkitik.radix.develop.store.storeCreator
import io.arkitik.radix.develop.usecase.command
import io.arkitik.radix.develop.usecase.execute
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

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
        workflowDomainUseCaseFactory.command {
            validateWorkflowExistenceUseCase
        } execute ExistByKeyRequest(workflowKey)
    }

    override fun CreateWorkflowRequest.doProcess(): ViewIdentify {
        val workflow = workflowStore.run {
            storeCreator(identityCreator()) {
                workflowDescription.workflowDescription()
                workflowKey.workflowKey()
                workflowName.workflowName()
                create()
            }.save()
        }
        return ViewIdentify(workflow.uuid, workflow.workflowKey)
    }
}
