package io.quee.clef.workflow.api.usecase.factory.element

import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ElementByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementUseCaseFactory : UseCaseFactory {
    val createElementUseCase: FunctionalUseCase<CreateElementRequest, ViewIdentify>
    val executeActionIntoElementUseCase: FunctionalUseCase<ExecuteActionRequest, SharedResponse>
    val elementFullDetailsUseCase: FunctionalUseCase<RequestAdapter<ElementByKeyRequest>, ElementFullDetailsResponse>
}