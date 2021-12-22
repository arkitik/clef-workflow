package io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task

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
data class CreateTaskRequest(
    @get:NotBlank val taskKey: String,
    @get:NotBlank val taskName: String,
    @get:NotNull val initialTask: Boolean,
    @get:NotNull @get:Valid val stage: DomainKeyRequest,
) : UseCaseRequest