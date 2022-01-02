package io.arkitik.clef.workflow.api.usecase.factory.domain.response.action

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 6:48 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
data class TaskActionsResponse(
    val actions: List<ActionIdentity>,
) : UseCaseResponse
