package io.quee.clef.workflow.api.usecase.domain.workflow.main

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ValidateWorkflowExistenceUseCase(private val workflowStoreQuery: WorkflowStoreQuery) :
    ValidationCommandUseCase<ExistByKeyRequest>() {
    override fun ExistByKeyRequest.doExecute() {
        if (workflowStoreQuery.existByKey(domainKey)) {
            throw NotAcceptableException(WorkflowResponses.Errors.DUPLICATE_WORKFLOW_ERROR)
        }
    }
}