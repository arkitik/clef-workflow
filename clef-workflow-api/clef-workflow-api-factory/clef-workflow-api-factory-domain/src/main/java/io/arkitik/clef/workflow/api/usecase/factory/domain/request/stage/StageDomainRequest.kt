package io.arkitik.clef.workflow.api.usecase.factory.domain.request.stage

import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 6:41 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
data class StageDomainRequest(
    val stage: StageIdentity,
) : UseCaseRequest
