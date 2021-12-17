package io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture

import io.arkitik.radix.develop.usecase.model.UseCaseResponse
import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class TaskStructure(
    val taskUuid: String,
    val taskKey: String,
    val taskName: String,
    val status: IdentityStatus,
    val actions: List<TaskActionStructure>,
) : UseCaseResponse