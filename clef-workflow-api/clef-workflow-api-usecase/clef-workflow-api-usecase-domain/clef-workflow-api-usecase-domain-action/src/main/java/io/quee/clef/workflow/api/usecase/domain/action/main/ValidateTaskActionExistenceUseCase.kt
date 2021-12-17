package io.quee.clef.workflow.api.usecase.domain.action.main

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.quee.clef.workflow.api.common.error.StageTaskResponses
import io.quee.clef.workflow.api.store.action.query.TaskActionStoreQuery
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ValidateTaskActionExistenceUseCase(private val taskActionStoreQuery: TaskActionStoreQuery) :
    ValidationCommandUseCase<ExistByKeyRequest>() {
    override fun ExistByKeyRequest.doExecute() {
        if (taskActionStoreQuery.existByKey(domainKey)) {
            throw NotAcceptableException(StageTaskResponses.Errors.DUPLICATE_TASK_ERROR)
        }
    }
}