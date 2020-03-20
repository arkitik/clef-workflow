package io.quee.clef.workflow.api.usecase.factory.element.request

import io.quee.api.develop.shared.Constants
import io.quee.api.develop.usecase.model.UseCaseRequest
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface CreateElementRequest : UseCaseRequest {
    @get:NotBlank
    @get:Pattern(regexp = Constants.USER_NAME_REGEX)
    val elementKey: String

    @get:NotNull
    @get:Valid
    val workflow: ElementByUuidAndKey
}