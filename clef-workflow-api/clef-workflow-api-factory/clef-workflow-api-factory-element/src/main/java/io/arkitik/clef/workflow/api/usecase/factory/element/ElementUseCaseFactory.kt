package io.arkitik.clef.workflow.api.usecase.factory.element

import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.ElementByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementUseCaseFactory : UseCaseFactory {
    val createElementUseCase: FunctionalUseCase<CreateElementRequest, ViewIdentify>
    val executeActionIntoElementUseCase: FunctionalUseCase<ExecuteActionRequest, SharedResponse>
    val elementFullDetailsUseCase: FunctionalUseCase<ElementByKeyRequest, ElementFullDetailsResponse>
}