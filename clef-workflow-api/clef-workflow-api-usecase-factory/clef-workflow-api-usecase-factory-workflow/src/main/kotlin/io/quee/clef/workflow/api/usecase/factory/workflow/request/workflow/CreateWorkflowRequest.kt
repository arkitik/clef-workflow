package io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow

import io.quee.api.develop.shared.Constants
import io.quee.api.develop.usecase.model.UseCaseRequest
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface CreateWorkflowRequest : UseCaseRequest {
    @get:NotBlank
    @get:Pattern(regexp = Constants.USER_NAME_REGEX)
    val workflowKey: String

    @get:NotBlank
    val workflowName: String

    @get:NotBlank
    val workflowDescription: String
}