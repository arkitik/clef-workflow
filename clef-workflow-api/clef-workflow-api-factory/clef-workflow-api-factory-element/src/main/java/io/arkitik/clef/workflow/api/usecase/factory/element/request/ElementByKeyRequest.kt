package io.arkitik.clef.workflow.api.usecase.factory.element.request

import io.arkitik.radix.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class ElementByKeyRequest(
    val key: String,
) : UseCaseRequest