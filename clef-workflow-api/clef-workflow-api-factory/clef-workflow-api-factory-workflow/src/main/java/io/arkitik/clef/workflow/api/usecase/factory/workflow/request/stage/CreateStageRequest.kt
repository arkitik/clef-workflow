package io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage

import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.DomainKeyRequest
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class CreateStageRequest(
    @get:NotBlank
    val stageKey: String,
    @get:NotBlank
    val stageName: String,
    @get:NotNull
    val initialStage: Boolean,
    @get:NotNull
    @get:Valid
    val workflow: DomainKeyRequest,
) : UseCaseRequest