package io.quee.clef.workflow.api.usecase.domain.element

import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.api.develop.usecase.type.CommandUseCase
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.store.element.query.ElementStoreQuery
import io.quee.clef.workflow.api.usecase.domain.element.main.FindElementByKeyAndUuidUseCase
import io.quee.clef.workflow.api.usecase.domain.element.main.ValidateStageExistenceUseCase
import io.quee.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.ElementExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.FindElementByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementDomainUseCaseFactoryImpl(
        elementStoreQuery: ElementStoreQuery
) : ElementDomainUseCaseFactory {
    override val findElementByKeyAndUuidUseCase: FunctionalUseCase<FindElementByKeyAndUuidRequest, ResponseAdapter<ElementIdentity>> =
            FindElementByKeyAndUuidUseCase(elementStoreQuery)
    override val validateStageExistenceUseCase: CommandUseCase<ElementExistByKeyRequest> =
            ValidateStageExistenceUseCase(elementStoreQuery)
}