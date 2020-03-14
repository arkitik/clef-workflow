package io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow

import io.quee.api.develop.usecase.model.UseCaseRequest
import javax.validation.constraints.NotBlank

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface CreateWorkflowRequest : UseCaseRequest {
    @get:NotBlank
    val workflowKey: String

    @get:NotBlank
    val workflowName: String

    @get:NotBlank
    val workflowDescription: String
}