package io.quee.clef.workflow.api.usecase.factory.workflow.response.task

import io.quee.api.develop.usecase.model.UseCaseResponse
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
data class TaskDetailsResponse(
        val stageUuid: String,
        val stageKey: String,
        val initialAction: ViewIdentify,
        val actions: List<ViewIdentify>
) : UseCaseResponse