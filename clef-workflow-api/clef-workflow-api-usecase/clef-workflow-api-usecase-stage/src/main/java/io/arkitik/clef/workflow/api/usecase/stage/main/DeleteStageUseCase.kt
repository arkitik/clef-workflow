package io.arkitik.clef.workflow.api.usecase.stage.main

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.error.StageResponses
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DeleteStageUseCase(
    private val identityStatusValidation: IdentityStatusValidation,
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
) : ValidationFunctionalUseCase<StageRequest, SharedResponse>() {
    override fun StageRequest.doProcess(): SharedResponse {
        val taskAction = stageDomainUseCaseFactory.findStageByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(stageKey, false)
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