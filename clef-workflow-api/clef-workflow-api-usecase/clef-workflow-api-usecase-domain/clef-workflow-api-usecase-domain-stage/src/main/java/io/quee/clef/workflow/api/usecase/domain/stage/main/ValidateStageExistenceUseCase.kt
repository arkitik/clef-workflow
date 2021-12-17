package io.quee.clef.workflow.api.usecase.domain.stage.main

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.quee.clef.workflow.api.common.error.StageResponses
import io.quee.clef.workflow.api.store.stage.query.StageStoreQuery
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ValidateStageExistenceUseCase(private val stageStoreQuery: StageStoreQuery) :
    ValidationCommandUseCase<ExistByKeyRequest>() {
    override fun ExistByKeyRequest.doExecute() {
        if (stageStoreQuery.existByKey(domainKey)) {
            throw NotAcceptableException(StageResponses.Errors.DUPLICATE_STAGE_ERROR)
        }
    }
}