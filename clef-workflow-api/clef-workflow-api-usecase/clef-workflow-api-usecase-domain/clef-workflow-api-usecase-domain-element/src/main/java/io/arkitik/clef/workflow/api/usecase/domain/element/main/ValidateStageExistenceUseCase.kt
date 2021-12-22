package io.arkitik.clef.workflow.api.usecase.domain.element.main

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.arkitik.clef.workflow.api.common.error.ElementResponses
import io.arkitik.clef.workflow.api.store.element.query.ElementStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ValidateStageExistenceUseCase(
    private val elementStoreQuery: ElementStoreQuery,
) : ValidationCommandUseCase<ElementKeyRequest>() {
    override fun ElementKeyRequest.doExecute() {
        if (elementStoreQuery.existByKey(domainKey)) {
            throw NotAcceptableException(ElementResponses.Errors.DUPLICATE_TASK_ERROR)
        }
    }
}