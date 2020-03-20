package io.quee.clef.workflow.api.usecase.factory.element.domain

import io.quee.api.develop.usecase.factory.UseCaseFactory
import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.api.develop.usecase.type.CommandUseCase
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.ElementExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.FindElementByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface ElementDomainUseCaseFactory : UseCaseFactory {
    val findElementByKeyAndUuidUseCase: FunctionalUseCase<FindElementByKeyAndUuidRequest, ResponseAdapter<ElementIdentity>>
    val validateStageExistenceUseCase: CommandUseCase<ElementExistByKeyRequest>
}