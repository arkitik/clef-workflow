package io.arkitik.clef.workflow.api.usecase.domain.action

import io.arkitik.clef.workflow.api.store.action.ActionStore
import io.arkitik.clef.workflow.api.usecase.domain.action.main.FindTaskActionByKeyUseCase
import io.arkitik.clef.workflow.api.usecase.domain.action.main.FindTaskActionsUseCase
import io.arkitik.clef.workflow.api.usecase.domain.action.main.ValidateTaskActionExistenceUseCase
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ActionDomainUseCaseFactoryImpl(
    actionStore: ActionStore,
) : ActionDomainUseCaseFactory {
    override val findActionByKeyUseCase = FindTaskActionByKeyUseCase(actionStore.storeQuery)
    override val validateActionExistenceUseCase = ValidateTaskActionExistenceUseCase(actionStore.storeQuery)
    override val findTaskActionsUseCase = FindTaskActionsUseCase(actionStore.storeQuery)
}
