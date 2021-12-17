package io.quee.clef.workflow.api.port.task

import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.task.StageTaskStore
import io.quee.clef.workflow.api.usecase.domain.task.StageTaskDomainUseCaseFactoryImpl
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.quee.clef.workflow.api.usecase.task.TaskUseCaseFactoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Configuration
class TaskContextPort {
    @Bean
    fun stageTaskDomainUseCaseFactory(
        stageTaskStore: StageTaskStore,
        identityAccessValidation: IdentityAccessValidation,
        actionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
    ): StageTaskDomainUseCaseFactory =
        StageTaskDomainUseCaseFactoryImpl(stageTaskStore, identityAccessValidation, actionDomainUseCaseFactory)

    @Bean
    fun taskUseCaseFactory(
        stageTaskStore: StageTaskStore,
        stageTaskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
        identityStatusValidation: IdentityStatusValidation,
        stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    ): TaskUseCaseFactory = TaskUseCaseFactoryImpl(stageTaskStore,
        stageTaskDomainUseCaseFactory,
        identityStatusValidation,
        stageDomainUseCaseFactory)
}