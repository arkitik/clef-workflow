package io.arkitik.clef.workflow.api.usecase.domain.workflow.main

import io.arkitik.clef.workflow.api.common.error.WorkflowResponses
import io.arkitik.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.radix.develop.shared.ext.notAcceptable
import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ValidateWorkflowExistenceUseCase(private val workflowStoreQuery: WorkflowStoreQuery) :
    ValidationCommandUseCase<ExistByKeyRequest>() {
    override fun ExistByKeyRequest.doExecute() {
        if (workflowStoreQuery.existByKey(domainKey)) {
            throw WorkflowResponses.Errors.DUPLICATE_WORKFLOW_ERROR.notAcceptable()
        }
    }
}
