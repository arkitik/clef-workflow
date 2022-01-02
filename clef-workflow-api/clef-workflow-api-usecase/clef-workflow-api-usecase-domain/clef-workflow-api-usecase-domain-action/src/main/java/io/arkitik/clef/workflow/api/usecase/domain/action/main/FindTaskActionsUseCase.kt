package io.arkitik.clef.workflow.api.usecase.domain.action.main

import io.arkitik.clef.workflow.api.store.action.query.ActionStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.task.TaskDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.response.action.TaskActionsResponse
import io.arkitik.radix.develop.usecase.FunctionalUseCase

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 7:32 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class FindTaskActionsUseCase(
    private val actionStoreQuery: ActionStoreQuery,
) : FunctionalUseCase<TaskDomainRequest, TaskActionsResponse> {
    override fun TaskDomainRequest.process() =
        TaskActionsResponse(
            actionStoreQuery.findAllByTask(task)
        )
}
