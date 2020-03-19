package io.quee.clef.workflow.api.usecase.domain.stage.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.ResourceNotFoundException
import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.clef.workflow.api.common.error.SharedErrors
import io.quee.clef.workflow.api.common.error.StageResponses
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.stage.query.StageStoreQuery
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FindStageByKeyAndUuidUseCase(
        private val stageStoreQuery: StageStoreQuery
) : ValidationFunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<StageIdentity>>() {
    override fun FindDomainByKeyAndUuidRequest.realProcess(): ResponseAdapter<StageIdentity> {
        val stageIdentity = stageStoreQuery.findByKeyAndUuid(domainKey, domainUuid)
        if (stageIdentity != null) {
            stageIdentity.validate(shouldBeDisabled)
            return ResponseAdapter(stageIdentity)
        }
        throw ResourceNotFoundException(StageResponses.Errors.STAGE_DOES_NOT_EXIST)
    }

    private fun Identity.validate(shouldBeDisabled: Boolean) {
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