package io.quee.clef.workflow.api.usecase.factory.element.domain.request

import io.quee.api.develop.usecase.model.UseCaseRequest
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface FindElementByKeyAndUuidRequest : UseCaseRequest {
    @get:NotBlank
    val domainKey: String

    @get:NotBlank
    val domainUuid: String

    @get:NotNull
    val shouldBeDisabled: Boolean

    companion object {
        fun instance(
                domainKey: String,
                domainUuid: String,
                shouldBeDisabled: Boolean = false
        ): FindElementByKeyAndUuidRequest {
            return object : FindElementByKeyAndUuidRequest {
                override val domainKey: String = domainKey
                override val domainUuid: String = domainUuid
                override val shouldBeDisabled: Boolean = shouldBeDisabled
            }
        }
    }
}