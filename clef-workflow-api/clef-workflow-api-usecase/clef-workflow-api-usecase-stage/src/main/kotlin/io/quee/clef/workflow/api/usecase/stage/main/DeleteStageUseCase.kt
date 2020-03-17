package io.quee.clef.workflow.api.usecase.stage.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.clef.workflow.api.common.error.StageResponses
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DeleteStageUseCase(
        private val identityStatusValidation: IdentityStatusValidation,
        private val stageDomainUseCaseFactory: StageDomainUseCaseFactory
) : ValidationFunctionalUseCase<StageRequest, SharedResponse>() {
    override fun StageRequest.realProcess(): SharedResponse {
        val taskAction = stageDomainUseCaseFactory.findStageByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(stageKey, stageUuid)
                            .process()
                            .response
                }
        taskAction.identityStatus.validate()
        stageDomainUseCaseFactory.deleteAllStagesUseCase
                .run {
                    RequestAdapter(listOf(taskAction))
                            .execute()
                }
        return StageResponses.STAGE_DELETED_SUCCESS
    }

    private fun IdentityStatus.validate() {
        identityStatusValidation.run {
            validate(IdentityStatus.DELETED)
        }
    }
}