package io.quee.clef.workflow.api.usecase.factory.element.domain.request

import io.arkitik.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class ElementKeyRequest(
    val domainKey: String,
    val shouldBeDisabled: Boolean = false,
) : UseCaseRequest