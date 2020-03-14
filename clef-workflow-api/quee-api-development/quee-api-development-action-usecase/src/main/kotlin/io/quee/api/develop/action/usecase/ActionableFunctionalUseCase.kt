package io.quee.api.develop.action.usecase

import io.quee.api.develop.action.usecase.action.ActionableWithResponse
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.model.UseCaseResponse
import io.quee.api.develop.usecase.type.FunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **07**, **Sat Mar, 2020**
 */
abstract class ActionableFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse> : FunctionalUseCase<RQ, RS>, ActionableWithResponse<RQ, RS> {
    final override fun RQ.process(): RS {
        before()
        val response = realProcess()
        after(response)
        return response
    }

    protected abstract fun RQ.realProcess(): RS
}