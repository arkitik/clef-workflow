package io.arkitik.clef.workflow.api.port.stage

import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.stage.InitialStageStore
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.usecase.domain.stage.StageDomainUseCaseFactoryImpl
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.stage.StageUseCaseFactoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Configuration
class StageContextPort {

    @Bean
    fun stageDomainUseCaseFactory(
        stageStore: StageStore,
        initialStageStore: InitialStageStore,
    ): StageDomainUseCaseFactory =
        StageDomainUseCaseFactoryImpl(
            stageStore,
            initialStageStore
        )

    @Bean
    fun stageUseCaseFactory(
        stageStore: StageStore,
        initialStageStore: InitialStageStore,
        stageDomainUseCaseFactory: StageDomainUseCaseFactory,
        identityStatusValidation: IdentityStatusValidation,
        workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
        taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
    ): StageUseCaseFactory =
        StageUseCaseFactoryImpl(
            stageStore = stageStore,
            initialStageStore = initialStageStore,
            stageDomainUseCaseFactory = stageDomainUseCaseFactory,
            identityStatusValidation = identityStatusValidation,
            workflowDomainUseCaseFactory = workflowDomainUseCaseFactory,
            taskDomainUseCaseFactory = taskDomainUseCaseFactory,
        )
}
