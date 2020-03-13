package io.quee.api.develop.reactive.usecase

import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.model.UseCaseResponse
import io.quee.api.develop.usecase.type.UseCase
import io.reactivex.Observable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
interface RxUseCase<RQ : UseCaseRequest, RS : UseCaseResponse> : UseCase<RQ, RS> {
    fun process(data: RQ): Observable<RS>
}