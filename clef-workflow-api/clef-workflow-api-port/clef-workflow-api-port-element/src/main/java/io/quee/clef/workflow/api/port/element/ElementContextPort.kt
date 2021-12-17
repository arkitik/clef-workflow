package io.quee.clef.workflow.api.port.element

import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.element.ElementFlowStore
import io.quee.clef.workflow.api.store.element.ElementStore
import io.quee.clef.workflow.api.usecase.domain.element.ElementDomainUseCaseFactoryImpl
import io.quee.clef.workflow.api.usecase.element.ElementUseCaseFactoryImpl
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Configuration
class ElementContextPort {
    @Bean
    fun elementUseCaseFactory(
        elementStore: ElementStore,
        elementFlowStore: ElementFlowStore,
        elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
        workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
        taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
        identityAccessValidation: IdentityAccessValidation,
        stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    ): ElementUseCaseFactory =
        ElementUseCaseFactoryImpl(
            elementStore,
            elementFlowStore,
            elementDomainUseCaseFactory,
            workflowDomainUseCaseFactory,
            taskActionDomainUseCaseFactory,
            identityAccessValidation,
            stageDomainUseCaseFactory
        )

    @Bean
    fun elementDomainUseCaseFactory(elementStore: ElementStore): ElementDomainUseCaseFactory =
        ElementDomainUseCaseFactoryImpl(elementStore.storeQuery)
}