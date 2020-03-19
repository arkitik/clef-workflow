package io.quee.clef.workflow.api.usecase.domain.action.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.ResourceNotFoundException
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.clef.workflow.api.common.error.StageTaskResponses
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.action.query.TaskActionStoreQuery
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FindTaskActionByKeyAndUuidUseCase(
        private val taskActionStoreQuery: TaskActionStoreQuery,
        private val identityAccessValidation: IdentityAccessValidation
) : ValidationFunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<TaskActionIdentity>>() {
    override fun FindDomainByKeyAndUuidRequest.realProcess(): ResponseAdapter<TaskActionIdentity> {
        val taskActionIdentity = taskActionStoreQuery.findByKeyAndUuid(domainKey, domainUuid)
        if (taskActionIdentity != null) {
            identityAccessValidation.run {
                taskActionIdentity.identityStatus.validate()
            }
            return ResponseAdapter(taskActionIdentity)
        }
        throw ResourceNotFoundException(StageTaskResponses.Errors.TASK_DOES_NOT_EXIST)
    }
}