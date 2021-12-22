package io.arkitik.clef.workflow.api.usecase.factory.workflow.response.task

import io.arkitik.radix.develop.usecase.model.UseCaseResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class TaskDetailsResponse(
    val taskUuid: String,
    val taskKey: String,
    val taskName: String,
    val actions: List<ViewIdentify>,
) : UseCaseResponse