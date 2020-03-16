package io.quee.clef.workflow.api.usecase.domain.workflow.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.ResourceNotFoundException
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.clef.workflow.api.common.error.StageTaskResponses
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FindWorkflowByKeyAndUuidUseCase(
        private val workflowStoreQuery: WorkflowStoreQuery,
        private val identityAccessValidation: IdentityAccessValidation
) : ValidationFunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<WorkflowIdentity>>() {
    override fun FindDomainByKeyAndUuidRequest.realProcess(): ResponseAdapter<WorkflowIdentity> {
        val workflowIdentity = workflowStoreQuery.findByKeyAndUuid(domainKey, domainUuid)
        if (workflowIdentity != null) {
            identityAccessValidation.run {
                workflowIdentity.identityStatus.validate()
            }
            return ResponseAdapter(workflowIdentity)
        }
        throw ResourceNotFoundException(StageTaskResponses.Errors.TASK_DOES_NOT_EXIST)
    }
}