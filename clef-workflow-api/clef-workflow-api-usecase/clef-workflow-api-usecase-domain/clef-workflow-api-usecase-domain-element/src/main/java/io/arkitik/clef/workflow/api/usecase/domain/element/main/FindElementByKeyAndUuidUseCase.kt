package io.arkitik.clef.workflow.api.usecase.domain.element.main

import io.arkitik.radix.develop.shared.exception.ResourceNotFoundException
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.error.ElementResponses
import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.store.element.query.ElementStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class FindElementByKeyAndUuidUseCase(
    private val elementStoreQuery: ElementStoreQuery,
) : ValidationFunctionalUseCase<ElementKeyRequest, ResponseAdapter<ElementIdentity>>() {
    override fun ElementKeyRequest.doProcess(): ResponseAdapter<ElementIdentity> {
        val elementIdentity = elementStoreQuery.findByKey(domainKey)
        if (elementIdentity != null) {
            elementIdentity.validate(shouldBeDisabled)
            return ResponseAdapter(elementIdentity)
        }
        throw ResourceNotFoundException(ElementResponses.Errors.ELEMENT_DOES_NOT_EXIST)

    }

    private fun ElementIdentity.validate(shouldBeDisabled: Boolean) {
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