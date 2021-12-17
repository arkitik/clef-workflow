package io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow

import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class CreateWorkflowRequest(
    @get:NotBlank @get:Pattern(regexp = "^(?=[a-zA-Z0-9._-]{3,40}$)(?!.*[-_.]{2})[^-_.].*[^-_.]$") val workflowKey: String,
    @get:NotBlank val workflowName: String,
    @get:NotBlank val workflowDescription: String,
) : UseCaseRequest