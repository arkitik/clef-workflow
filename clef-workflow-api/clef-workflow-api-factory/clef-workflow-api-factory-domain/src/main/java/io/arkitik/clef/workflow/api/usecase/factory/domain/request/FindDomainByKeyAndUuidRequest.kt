package io.arkitik.clef.workflow.api.usecase.factory.domain.request

import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class FindDomainByKeyAndUuidRequest(
    @get:NotBlank
    val domainKey: String,
    @get:NotNull
    val shouldBeDisabled: Boolean,
) : UseCaseRequest