package io.quee.clef.workflow.api.usecase.domain.stage.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.ResourceNotFoundException
import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.clef.workflow.api.common.error.SharedErrors
import io.quee.clef.workflow.api.common.error.StageResponses
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.stage.query.StageStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **21**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FindStageByTaskUseCase(
        private val stageStoreQuery: StageStoreQuery
) : ValidationFunctionalUseCase<RequestAdapter<StageTaskIdentity>, ResponseAdapter<StageIdentity>>() {
    override fun RequestAdapter<StageTaskIdentity>.realProcess(): ResponseAdapter<StageIdentity> {
        val stageIdentity = stageStoreQuery.findByTask(request)
        if (stageIdentity != null) {
            stageIdentity.validate()
            return ResponseAdapter(stageIdentity)
        }
        throw ResourceNotFoundException(StageResponses.Errors.STAGE_DOES_NOT_EXIST)
    }

    private fun Identity.validate() {
        if (identityStatus == IdentityStatus.DELETED) throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DELETED_ERROR)
        else if (identityStatus == IdentityStatus.DISABLED) throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DISABLED_ERROR)
    }
}