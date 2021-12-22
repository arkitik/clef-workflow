package io.arkitik.clef.workflow.api.usecase.factory.element.domain

import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementDomainUseCaseFactory : UseCaseFactory {
    val findElementByKeyAndUuidUseCase: FunctionalUseCase<ElementKeyRequest, ResponseAdapter<ElementIdentity>>
    val validateStageExistenceUseCase: CommandUseCase<ElementKeyRequest>
}