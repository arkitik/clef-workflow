package io.quee.clef.workflow.api.usecase.factory.workflow.request.action

import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.DomainKeyRequest
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class CreateTaskActionRequest(
    @get:NotBlank
    val actionKey: String,
    @get:NotBlank
    val actionName: String,
    @get:NotBlank
    val actionDescription: String,
    @get:NotNull
    @get:Valid
    val sourceTask: DomainKeyRequest,
    @get:NotNull
    @get:Valid
    val destinationTask: DomainKeyRequest,
    val parameters: List<TaskActionParamRequest>,
) : UseCaseRequest