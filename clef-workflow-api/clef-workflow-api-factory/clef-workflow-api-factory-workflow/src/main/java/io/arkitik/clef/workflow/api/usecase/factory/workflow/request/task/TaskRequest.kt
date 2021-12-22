package io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task

import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import javax.validation.constraints.NotBlank

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class TaskRequest(
    @get:NotBlank
    val taskKey: String,
) : UseCaseRequest