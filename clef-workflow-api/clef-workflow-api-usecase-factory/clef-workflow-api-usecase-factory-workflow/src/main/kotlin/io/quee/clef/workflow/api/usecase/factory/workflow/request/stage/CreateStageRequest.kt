package io.quee.clef.workflow.api.usecase.factory.workflow.request.stage

import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface CreateStageRequest : UseCaseRequest {
    @get:NotBlank
    val stageKey: String

    @get:NotBlank
    val stageName: String

    @get:NotNull
    val initialStage: Boolean

    @get:NotNull
    @get:Valid
    val workflow: ViewIdentify
}