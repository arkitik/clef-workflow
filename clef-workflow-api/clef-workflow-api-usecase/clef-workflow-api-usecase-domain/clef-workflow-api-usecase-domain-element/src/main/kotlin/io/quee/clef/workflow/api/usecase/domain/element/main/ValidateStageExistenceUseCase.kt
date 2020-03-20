package io.quee.clef.workflow.api.usecase.domain.element.main

import io.quee.api.develop.action.usecase.validation.ValidationCommandUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.clef.workflow.api.common.error.ElementResponses
import io.quee.clef.workflow.api.store.element.query.ElementStoreQuery
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.ElementExistByKeyRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ValidateStageExistenceUseCase(
        private val elementStoreQuery: ElementStoreQuery
) : ValidationCommandUseCase<ElementExistByKeyRequest>() {
    override fun ElementExistByKeyRequest.realExecute() {
        if (elementStoreQuery.existByKey(domainKey)) {
            throw NotAcceptableException(ElementResponses.Errors.DUPLICATE_TASK_ERROR)
        }
    }
}