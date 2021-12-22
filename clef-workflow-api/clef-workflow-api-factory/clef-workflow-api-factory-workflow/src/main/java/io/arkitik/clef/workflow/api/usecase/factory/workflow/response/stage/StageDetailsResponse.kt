package io.arkitik.clef.workflow.api.usecase.factory.workflow.response.stage

import io.arkitik.radix.develop.usecase.model.UseCaseResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class StageDetailsResponse(
    val stageUuid: String,
    val stageKey: String,
    val stageName: String,
    val initialTask: ViewIdentify?,
    val tasks: List<ViewIdentify>,
) : UseCaseResponse