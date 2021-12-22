package io.arkitik.clef.workflow.api.port.task

import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.task.StageTaskStore
import io.arkitik.clef.workflow.api.usecase.domain.task.StageTaskDomainUseCaseFactoryImpl
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.task.TaskUseCaseFactoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
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