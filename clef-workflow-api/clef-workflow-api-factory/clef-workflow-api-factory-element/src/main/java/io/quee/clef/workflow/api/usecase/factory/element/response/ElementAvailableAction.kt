package io.quee.clef.workflow.api.usecase.factory.element.response

import javax.validation.constraints.NotBlank

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class ElementAvailableAction(
    @get:NotBlank val uuid: String,
    @get:NotBlank val key: String,
    @get:NotBlank val name: String,
    val parameters: List<ElementAvailableActionParameter>,
)