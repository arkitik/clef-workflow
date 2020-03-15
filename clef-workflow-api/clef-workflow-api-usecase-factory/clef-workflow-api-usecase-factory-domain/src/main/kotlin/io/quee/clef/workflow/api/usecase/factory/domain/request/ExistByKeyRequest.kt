package io.quee.clef.workflow.api.usecase.factory.domain.request

import io.quee.api.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ExistByKeyRequest : UseCaseRequest {
    val domainKey: String

    companion object {
        fun instance(domainKey: String): ExistByKeyRequest {
            return object : ExistByKeyRequest {
                override val domainKey: String = domainKey
            }
        }
    }
}