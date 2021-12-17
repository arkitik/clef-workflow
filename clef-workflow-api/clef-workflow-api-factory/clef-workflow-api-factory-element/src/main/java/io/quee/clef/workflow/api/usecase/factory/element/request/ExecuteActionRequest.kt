package io.quee.clef.workflow.api.usecase.factory.element.request

import io.arkitik.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class ExecuteActionRequest(
    val element: ElementByKeyRequest,
    val action: ElementByKeyRequest,
) : UseCaseRequest