package io.arkitik.clef.workflow.api.usecase.action

import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.action.ActionParameterStore
import io.arkitik.clef.workflow.api.store.action.ActionStore
import io.arkitik.clef.workflow.api.usecase.action.main.*
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.ActionUseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ActionUseCaseFactoryImpl(
    actionStore: ActionStore,
    actionParameterStore: ActionParameterStore,
    taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
    actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
    identityStatusValidation: IdentityStatusValidation,
) : ActionUseCaseFactory {
    override val createActionUseCase =
        CreateActionUseCase(
            actionStore = actionStore,
            actionParameterStore = actionParameterStore,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory,
            taskDomainUseCaseFactory = taskDomainUseCaseFactory
        )
    override val actionDetailsUseCase =
        ActionDetailsUseCase(
            actionParameterStoreQuery = actionParameterStore.storeQuery,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory,
        )
    override val enableActionUseCase =
        EnableActionUseCase(
            actionStore = actionStore,
            identityStatusValidation = identityStatusValidation,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory
        )
    override val disableActionUseCase =
        DisableActionUseCase(
            actionStore = actionStore,
            identityStatusValidation = identityStatusValidation,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory
        )
    override val deleteActionUseCase =
        DeleteActionUseCase(
            actionStore = actionStore,
            identityStatusValidation = identityStatusValidation,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory
        )
}
