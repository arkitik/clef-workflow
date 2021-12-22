package io.arkitik.clef.workflow.api.usecase.domain.task.main

import io.arkitik.radix.develop.shared.exception.ResourceNotFoundException
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.clef.workflow.api.common.error.StageTaskResponses
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.store.task.query.StageTaskStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class FindStageByKeyAndUuidUseCase(
    private val stageTaskStoreQuery: StageTaskStoreQuery,
) : ValidationFunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<StageTaskIdentity>>() {
    override fun FindDomainByKeyAndUuidRequest.doProcess(): ResponseAdapter<StageTaskIdentity> {
        val stageIdentity = stageTaskStoreQuery.findByKey(domainKey)
        if (stageIdentity != null) {
            stageIdentity.validate(shouldBeDisabled)
            return ResponseAdapter(stageIdentity)
        }
        throw ResourceNotFoundException(StageTaskResponses.Errors.TASK_DOES_NOT_EXIST)
    }

    private fun StageTaskIdentity.validate(shouldBeDisabled: Boolean) {
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