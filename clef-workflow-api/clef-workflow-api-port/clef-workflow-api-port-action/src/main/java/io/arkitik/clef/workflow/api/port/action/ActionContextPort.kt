package io.arkitik.clef.workflow.api.port.action

import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.action.ActionParameterStore
import io.arkitik.clef.workflow.api.store.action.ActionStore
import io.arkitik.clef.workflow.api.usecase.action.ActionUseCaseFactoryImpl
import io.arkitik.clef.workflow.api.usecase.domain.action.ActionDomainUseCaseFactoryImpl
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.ActionUseCaseFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Configuration
class ActionContextPort {
    @Bean
    fun taskActionDomainUseCaseFactory(
        actionStore: ActionStore,
        identityAccessValidation: IdentityAccessValidation,
    ): ActionDomainUseCaseFactory =
        ActionDomainUseCaseFactoryImpl(actionStore)

    @Bean
    fun taskActionUseCaseFactory(
        actionStore: ActionStore,
        actionParameterStore: ActionParameterStore,
        taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
        actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
        identityStatusValidation: IdentityStatusValidation,
    ): ActionUseCaseFactory = ActionUseCaseFactoryImpl(
        actionStore = actionStore,
        actionParameterStore = actionParameterStore,
        taskDomainUseCaseFactory = taskDomainUseCaseFactory,
        actionDomainUseCaseFactory = actionDomainUseCaseFactory,
        identityStatusValidation = identityStatusValidation,
    )
}
