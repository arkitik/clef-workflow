package io.quee.clef.workflow.api.usecase.factory.element.request

import io.quee.api.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ExecuteActionRequest : UseCaseRequest {
    val element: ElementByUuidAndKey
    val action: ElementByUuidAndKey
}