package io.arkitik.clef.workflow.api.usecase.stage.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageDetailsUseCase(
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
) : ValidationFunctionalUseCase<StageRequest, StageDetailsResponse>() {
    override fun StageRequest.doProcess(): StageDetailsResponse {
        val stage = stageDomainUseCaseFactory.findStageByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(stageKey, false)
                    .process()
                    .response
            }
        return StageDetailsResponse(
            stage.uuid,
            stage.stageKey,
            stage.stageName,
            viewIdentity(stage.initialTask),
            stage.tasks.map {
                stageViewIdentity(it)
            }
        )
    }

    private fun viewIdentity(stage: StageTaskIdentity?): ViewIdentify? {
        return if (stage != null) stageViewIdentity(stage) else null
    }

    private fun stageViewIdentity(stage: StageTaskIdentity): ViewIdentify {
        return ViewIdentify(stage.uuid, stage.taskKey)
    }
}