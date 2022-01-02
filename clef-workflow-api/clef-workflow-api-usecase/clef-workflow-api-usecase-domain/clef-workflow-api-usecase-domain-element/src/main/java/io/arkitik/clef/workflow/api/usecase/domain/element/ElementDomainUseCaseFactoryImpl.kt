package io.arkitik.clef.workflow.api.usecase.domain.element

import io.arkitik.clef.workflow.api.store.element.ElementStore
import io.arkitik.clef.workflow.api.usecase.domain.element.main.FindElementByKeyUseCase
import io.arkitik.clef.workflow.api.usecase.domain.element.main.ValidateStageExistenceUseCase
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementDomainUseCaseFactoryImpl(
    elementStore: ElementStore,
) : ElementDomainUseCaseFactory {
    override val findElementByKeyUseCase =
        FindElementByKeyUseCase(elementStore.storeQuery)
    override val validateStageExistenceUseCase =
        ValidateStageExistenceUseCase(elementStore.storeQuery)
}
