package io.arkitik.clef.workflow.api.usecase.factory.domain.response.task

import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 6:42 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
data class StageTasksResponse(
    val initialTask: TaskIdentity?,
    val tasks: List<TaskIdentity>,
) : UseCaseResponse
