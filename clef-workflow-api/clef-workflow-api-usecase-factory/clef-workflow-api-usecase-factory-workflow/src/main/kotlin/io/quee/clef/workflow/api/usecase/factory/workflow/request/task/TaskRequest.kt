package io.quee.clef.workflow.api.usecase.factory.workflow.request.task

import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest
import javax.validation.constraints.NotBlank

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface TaskRequest<T : UseCaseRequest> : StageRequest<T> {
    @get:NotBlank
    val taskKey: String

    @get:NotBlank
    val taskUuid: String
}