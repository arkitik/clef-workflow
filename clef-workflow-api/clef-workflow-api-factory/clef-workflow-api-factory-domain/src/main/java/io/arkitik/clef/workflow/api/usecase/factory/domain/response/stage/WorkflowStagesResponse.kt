package io.arkitik.clef.workflow.api.usecase.factory.domain.response.stage

import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 8:02 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
data class WorkflowStagesResponse(
    val initialStage: StageIdentity?,
    val stages: List<StageIdentity>,
) : UseCaseResponse
