package io.quee.clef.workflow.api.usecase.factory.element

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ElementByUuidAndKey
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
    val elementFullDetailsUseCase: FunctionalUseCase<RequestAdapter<ElementByUuidAndKey>, ElementFullDetailsResponse>
}