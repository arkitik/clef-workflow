package io.arkitik.clef.workflow.api.usecase.domain.task.main

import io.arkitik.clef.workflow.api.common.error.StageTaskResponses
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.store.task.query.InitialTaskStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.stage.StageDomainRequest
import io.arkitik.radix.develop.shared.ext.unprocessableEntity
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.adapter.toResponse

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 8:16 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class FindStageInitialTaskUseCase(
    private val initialTaskStoreQuery: InitialTaskStoreQuery,
) : FunctionalUseCase<StageDomainRequest, ResponseAdapter<TaskIdentity>> {

    override fun StageDomainRequest.process(): ResponseAdapter<TaskIdentity> {
        val initialTask = with(initialTaskStoreQuery) {
            findByStage(stage)
        } ?: throw StageTaskResponses.Errors.STAGE_DOES_NOT_HAVE_INITIAL_TASK.unprocessableEntity()
        return toResponse {
            initialTask.task
        }
    }
}
