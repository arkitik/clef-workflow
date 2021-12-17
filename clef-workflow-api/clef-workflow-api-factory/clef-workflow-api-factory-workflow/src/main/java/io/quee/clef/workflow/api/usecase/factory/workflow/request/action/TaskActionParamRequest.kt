package io.quee.clef.workflow.api.usecase.factory.workflow.request.action

import javax.validation.constraints.NotEmpty

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class TaskActionParamRequest(
    @get:NotEmpty
    val parameterKey: String,
    @get:NotEmpty
    val parameterValue: String,
)