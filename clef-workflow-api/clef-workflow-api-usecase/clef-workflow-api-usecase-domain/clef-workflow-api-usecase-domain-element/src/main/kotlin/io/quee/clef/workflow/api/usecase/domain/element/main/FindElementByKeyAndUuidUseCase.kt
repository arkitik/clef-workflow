package io.quee.clef.workflow.api.usecase.domain.element.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.ResourceNotFoundException
import io.quee.api.develop.shared.model.Identity
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.clef.workflow.api.common.error.ElementResponses
import io.quee.clef.workflow.api.common.error.SharedErrors
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.store.element.query.ElementStoreQuery
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.FindElementByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FindElementByKeyAndUuidUseCase(
        private val elementStoreQuery: ElementStoreQuery
) : ValidationFunctionalUseCase<FindElementByKeyAndUuidRequest, ResponseAdapter<ElementIdentity>>() {
    override fun FindElementByKeyAndUuidRequest.realProcess(): ResponseAdapter<ElementIdentity> {
        val elementIdentity = elementStoreQuery.findByKeyAndUuid(domainKey, domainUuid)
        if (elementIdentity != null) {
            elementIdentity.validate(shouldBeDisabled)
            return ResponseAdapter(elementIdentity)
        }
        throw ResourceNotFoundException(ElementResponses.Errors.ELEMENT_DOES_NOT_EXIST)

    }

    private fun Identity.validate(shouldBeDisabled: Boolean) {
        when (identityStatus) {
            IdentityStatus.DELETED -> throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DELETED_ERROR)
            IdentityStatus.ENABLED -> {
                if (shouldBeDisabled) {
                    throw ResourceNotFoundException(SharedErrors.IdentityStatusApi.RECORD_ALREADY_ENABLED_ERROR)
                }
            }
            IdentityStatus.DISABLED -> {
                if (!shouldBeDisabled) {
                    throw ResourceNotFoundException(SharedErrors.IdentityAccessApi.IDENTITY_DISABLED_ERROR)
                }
            }
        }
    }
}