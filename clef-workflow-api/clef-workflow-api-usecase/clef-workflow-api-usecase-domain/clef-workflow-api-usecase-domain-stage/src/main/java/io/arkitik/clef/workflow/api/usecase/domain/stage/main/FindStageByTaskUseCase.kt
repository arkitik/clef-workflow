package io.arkitik.clef.workflow.api.usecase.domain.stage.main

import io.arkitik.radix.develop.shared.exception.ResourceNotFoundException
import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.clef.workflow.api.common.error.StageResponses
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.store.stage.query.StageStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **21**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class FindStageByTaskUseCase(
    private val stageStoreQuery: StageStoreQuery,
) : ValidationFunctionalUseCase<RequestAdapter<StageTaskIdentity>, ResponseAdapter<StageIdentity>>() {
    override fun RequestAdapter<StageTaskIdentity>.doProcess(): ResponseAdapter<StageIdentity> {
        val stageIdentity = stageStoreQuery.findByTask(request)
        if (stageIdentity != null) {
            stageIdentity.validate()
            return ResponseAdapter(stageIdentity)
        }
        throw ResourceNotFoundException(StageResponses.Errors.STAGE_DOES_NOT_EXIST)
    }

    private fun StageIdentity.validate() {
        if (identityStatus == IdentityStatus.DELETED) throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DELETED_ERROR)
        else if (identityStatus == IdentityStatus.DISABLED) throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DISABLED_ERROR)
    }
}