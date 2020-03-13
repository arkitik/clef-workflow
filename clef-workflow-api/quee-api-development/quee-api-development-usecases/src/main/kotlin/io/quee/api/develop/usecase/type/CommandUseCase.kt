package io.quee.api.develop.usecase.type

import io.quee.api.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
@FunctionalInterface
interface CommandUseCase<RQ : UseCaseRequest> {
    fun RQ.execute()
}