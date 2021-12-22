package io.arkitik.clef.workflow.api.usecase.domain.element

import io.arkitik.clef.workflow.api.store.element.query.ElementStoreQuery
import io.arkitik.clef.workflow.api.usecase.domain.element.main.FindElementByKeyAndUuidUseCase
import io.arkitik.clef.workflow.api.usecase.domain.element.main.ValidateStageExistenceUseCase
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementDomainUseCaseFactoryImpl(
    elementStoreQuery: ElementStoreQuery,
) : ElementDomainUseCaseFactory {
    override val findElementByKeyAndUuidUseCase =
        FindElementByKeyAndUuidUseCase(elementStoreQuery)
    override val validateStageExistenceUseCase =
        ValidateStageExistenceUseCase(elementStoreQuery)
}