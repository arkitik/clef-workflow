package io.quee.clef.workflow.api.controller.element.dto

import io.quee.clef.workflow.api.usecase.factory.element.request.CreateElementRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class CreateElementRequestDto(
        override val elementKey: String,
        override val workflow: ElementByUuidAndKeyDto
) : CreateElementRequest