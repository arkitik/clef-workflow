package io.arkitik.clef.workflow.api.common.response

import io.arkitik.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class SharedResponse(
    val code: String,
    val message: String,
) : UseCaseResponse 