package io.arkitik.clef.workflow.api.usecase.domain.stage.main

import io.arkitik.radix.develop.shared.exception.ResourceNotFoundException
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.clef.workflow.api.common.error.StageResponses
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.store.stage.query.StageStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class FindStageByKeyUseCase(
    private val stageStoreQuery: StageStoreQuery,
) : ValidationFunctionalUseCase<FindDomainByKeyRequest, ResponseAdapter<StageIdentity>>() {
    override fun FindDomainByKeyRequest.doProcess(): ResponseAdapter<StageIdentity> {
        val stageIdentity = stageStoreQuery.findByKeyAndUuid(domainKey)
        if (stageIdentity != null) {
            stageIdentity.validate(shouldBeDisabled)
            return ResponseAdapter(stageIdentity)
        }
        throw ResourceNotFoundException(StageResponses.Errors.STAGE_DOES_NOT_EXIST)
    }

    private fun StageIdentity.validate(shouldBeDisabled: Boolean) {
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
