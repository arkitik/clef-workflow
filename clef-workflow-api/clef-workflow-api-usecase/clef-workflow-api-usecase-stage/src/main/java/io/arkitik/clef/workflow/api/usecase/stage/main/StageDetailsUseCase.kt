package io.arkitik.clef.workflow.api.usecase.stage.main

import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.stage.StageDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageDetailsUseCase(
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    private val taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
) : ValidationFunctionalUseCase<StageRequest, StageDetailsResponse>() {
    override fun StageRequest.doProcess(): StageDetailsResponse {
        val adapter = stageDomainUseCaseFactory.functional {
            findStageByKeyUseCase
        } process FindDomainByKeyRequest(stageKey, false)

        val response = taskDomainUseCaseFactory.functional {
            findStageTasksUseCase
        } process StageDomainRequest(adapter.response)

        return StageDetailsResponse(
            adapter.response.uuid,
            adapter.response.stageKey,
            adapter.response.stageName,
            response.initialTask?.viewIdentity(),
            response.tasks.map {
                it.viewIdentity()
            }
        )
    }

    private fun TaskIdentity.viewIdentity(): ViewIdentify {
        return ViewIdentify(uuid, taskKey)
    }
}
