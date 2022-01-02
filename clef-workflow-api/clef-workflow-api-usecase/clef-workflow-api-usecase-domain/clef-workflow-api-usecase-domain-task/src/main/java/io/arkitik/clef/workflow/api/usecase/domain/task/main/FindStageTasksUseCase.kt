package io.arkitik.clef.workflow.api.usecase.domain.task.main

import io.arkitik.clef.workflow.api.store.task.query.InitialTaskStoreQuery
import io.arkitik.clef.workflow.api.store.task.query.TaskStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.stage.StageDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.response.task.StageTasksResponse
import io.arkitik.radix.develop.usecase.FunctionalUseCase

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 8:16 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class FindStageTasksUseCase(
    private val taskStoreQuery: TaskStoreQuery,
    private val initialTaskStoreQuery: InitialTaskStoreQuery,
) : FunctionalUseCase<StageDomainRequest, StageTasksResponse> {
    override fun StageDomainRequest.process(): StageTasksResponse {
        val stages = with(taskStoreQuery) {
            findAllByStage(stage)
        }
        val initialTask = with(initialTaskStoreQuery) {
            findByStage(stage)
        }
        return StageTasksResponse(
            initialTask?.task,
            stages
        )
    }
}
