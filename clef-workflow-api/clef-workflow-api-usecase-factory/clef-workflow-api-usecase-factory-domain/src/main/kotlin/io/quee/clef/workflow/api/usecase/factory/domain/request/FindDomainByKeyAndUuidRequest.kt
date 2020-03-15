package io.quee.clef.workflow.api.usecase.factory.domain.request

import io.quee.api.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface FindDomainByKeyAndUuidRequest : UseCaseRequest {
    val domainKey: String
    val domainUuid: String

    companion object {
        fun instance(domainKey: String, domainUuid: String): FindDomainByKeyAndUuidRequest {
            return object : FindDomainByKeyAndUuidRequest {
                override val domainKey: String = domainKey
                override val domainUuid: String = domainUuid
            }
        }
    }
}