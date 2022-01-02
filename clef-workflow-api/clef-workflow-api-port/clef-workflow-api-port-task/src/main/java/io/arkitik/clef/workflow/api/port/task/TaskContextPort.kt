package io.arkitik.clef.workflow.api.port.task

import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.task.InitialTaskStore
import io.arkitik.clef.workflow.api.store.task.TaskStore
import io.arkitik.clef.workflow.api.usecase.domain.task.TaskDomainUseCaseFactoryImpl
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
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
        taskStore: TaskStore,
        initialTaskStore: InitialTaskStore,
    ): TaskDomainUseCaseFactory =
        TaskDomainUseCaseFactoryImpl(
            taskStore = taskStore,
            initialTaskStore = initialTaskStore,
        )

    @Bean
    fun taskUseCaseFactory(
        taskStore: TaskStore,
        initialTaskStore: InitialTaskStore,
        taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
        identityStatusValidation: IdentityStatusValidation,
        stageDomainUseCaseFactory: StageDomainUseCaseFactory,
        actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
    ): TaskUseCaseFactory = TaskUseCaseFactoryImpl(
        taskStore = taskStore,
        initialTaskStore = initialTaskStore,
        taskDomainUseCaseFactory = taskDomainUseCaseFactory,
        identityStatusValidation = identityStatusValidation,
        stageDomainUseCaseFactory = stageDomainUseCaseFactory,
        actionDomainUseCaseFactory = actionDomainUseCaseFactory,
    )
}
