package io.quee.clef.workflow.api.usecase.domain.task.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.ResourceNotFoundException
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.clef.workflow.api.common.error.StageTaskResponses
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.task.query.StageTaskStoreQuery
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FindStageByKeyAndUuidUseCase(
        private val stageTaskStoreQuery: StageTaskStoreQuery,
        private val identityAccessValidation: IdentityAccessValidation
) : ValidationFunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<StageTaskIdentity>>() {
    override fun FindDomainByKeyAndUuidRequest.realProcess(): ResponseAdapter<StageTaskIdentity> {
        val stageIdentity = stageTaskStoreQuery.findByKeyAndUuid(domainKey, domainUuid)
        if (stageIdentity != null) {
            identityAccessValidation.run {
                stageIdentity.identityStatus.validate()
            }
            return ResponseAdapter(stageIdentity)
        }
        throw ResourceNotFoundException(StageTaskResponses.Errors.TASK_DOES_NOT_EXIST)
    }
}