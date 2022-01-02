package io.arkitik.clef.workflow.api.usecase.domain.action.main

import io.arkitik.clef.workflow.api.common.error.TaskActionResponses
import io.arkitik.clef.workflow.api.store.action.query.ActionStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ValidateTaskActionExistenceUseCase(private val actionStoreQuery: ActionStoreQuery) :
    ValidationCommandUseCase<ExistByKeyRequest>() {
    override fun ExistByKeyRequest.doExecute() {
        actionStoreQuery.existByKey(domainKey)
            .takeIf { it }?.let {
                throw NotAcceptableException(TaskActionResponses.Errors.DUPLICATE_TASK_ACTION_ERROR)
            }
    }
}
