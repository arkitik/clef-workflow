package io.quee.clef.workflow.api.port.stage

import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.stage.StageStore
import io.quee.clef.workflow.api.usecase.domain.stage.StageDomainUseCaseFactoryImpl
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.quee.clef.workflow.api.usecase.stage.StageUseCaseFactoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Configuration
class StageContextPort {

    @Bean
    fun stageDomainUseCaseFactory(
        stageStore: StageStore,
        identityAccessValidation: IdentityAccessValidation,
        taskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
    ): StageDomainUseCaseFactory =
        StageDomainUseCaseFactoryImpl(stageStore, identityAccessValidation, taskDomainUseCaseFactory)

    @Bean
    fun stageUseCaseFactory(
        stageStore: StageStore,
        stageDomainUseCaseFactory: StageDomainUseCaseFactory,
        identityStatusValidation: IdentityStatusValidation,
        workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
    ): StageUseCaseFactory =
        StageUseCaseFactoryImpl(stageStore,
            stageDomainUseCaseFactory,
            identityStatusValidation,
            workflowDomainUseCaseFactory)
}