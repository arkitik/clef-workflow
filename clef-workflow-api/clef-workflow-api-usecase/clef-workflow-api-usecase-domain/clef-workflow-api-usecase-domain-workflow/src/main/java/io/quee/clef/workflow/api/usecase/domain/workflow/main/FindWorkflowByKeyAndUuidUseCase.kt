package io.quee.clef.workflow.api.usecase.domain.workflow.main

import io.arkitik.radix.develop.shared.exception.ResourceNotFoundException
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.error.SharedErrors
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FindWorkflowByKeyAndUuidUseCase(
    private val workflowStoreQuery: WorkflowStoreQuery,
) : ValidationFunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<WorkflowIdentity>>() {
    override fun FindDomainByKeyAndUuidRequest.doProcess(): ResponseAdapter<WorkflowIdentity> {
        val workflowIdentity = workflowStoreQuery.findByKey(domainKey)
        if (workflowIdentity != null) {
            workflowIdentity.validate(shouldBeDisabled)
            return ResponseAdapter(workflowIdentity)
        }
        throw ResourceNotFoundException(WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
    }

    private fun WorkflowIdentity.validate(shouldBeDisabled: Boolean) {
        when (identityStatus) {
            IdentityStatus.DELETED -> throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DELETED_ERROR)
            IdentityStatus.ENABLED -> {
                if (shouldBeDisabled) {
                    throw ResourceNotFoundException(SharedErrors.IdentityStatusApi.RECORD_ALREADY_ENABLED_ERROR)
                }
            }
            IdentityStatus.DISABLED -> {
                if (!shouldBeDisabled) {
                    throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DISABLED_ERROR)
                }
            }
        }
    }
}