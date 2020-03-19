package io.quee.clef.workflow.api.port.action

import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.action.TaskActionStore
import io.quee.clef.workflow.api.usecase.action.TaskActionUseCaseFactoryImpl
import io.quee.clef.workflow.api.usecase.domain.action.TaskActionDomainUseCaseFactoryImpl
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskActionUseCaseFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Configuration
class ActionContextPort {
    @Bean
    fun taskActionDomainUseCaseFactory(taskActionStore: TaskActionStore,
                                       identityAccessValidation: IdentityAccessValidation): TaskActionDomainUseCaseFactory =
            TaskActionDomainUseCaseFactoryImpl(taskActionStore)

    @Bean
    fun taskActionUseCaseFactory(
            taskActionStore: TaskActionStore,
            stageTaskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
            taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
            identityStatusValidation: IdentityStatusValidation
    ): TaskActionUseCaseFactory = TaskActionUseCaseFactoryImpl(
            taskActionStore,
            stageTaskDomainUseCaseFactory,
            taskActionDomainUseCaseFactory,
            identityStatusValidation
    )

}