package io.quee.clef.workflow.api.usecase.factory.element.request

import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class CreateElementRequest(
    @get:NotBlank
    @get:Pattern(regexp = "^(?=[a-zA-Z0-9._-]{3,40}$)(?!.*[-_.]{2})[^-_.].*[^-_.]$")
    val elementKey: String,
    @get:NotNull
    @get:Valid
    val workflow: ElementByKeyRequest,
) : UseCaseRequest