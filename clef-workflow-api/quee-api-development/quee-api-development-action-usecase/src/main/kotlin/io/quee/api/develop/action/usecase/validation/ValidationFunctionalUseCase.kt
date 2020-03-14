package io.quee.api.develop.action.usecase.validation

import io.quee.api.develop.action.usecase.ActionableFunctionalUseCase
import io.quee.api.develop.usecase.UseCaseValidator
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.model.UseCaseResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **07**, **Sat Mar, 2020**
 */
abstract class ValidationFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse>
    : ActionableFunctionalUseCase<RQ, RS>() {
    final override fun RQ.before() {
        UseCaseValidator.newInstance<RQ>().validate(this@before)
        extraValidation()
    }

    open fun RQ.extraValidation() {
        // do nothing
    }

    override fun RQ.after(response: RS) {
        // do nothing
    }
}