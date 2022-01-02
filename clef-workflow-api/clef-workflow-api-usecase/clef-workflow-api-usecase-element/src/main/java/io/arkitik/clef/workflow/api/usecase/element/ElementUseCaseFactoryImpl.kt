package io.arkitik.clef.workflow.api.usecase.element

import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.store.element.ElementFlowStore
import io.arkitik.clef.workflow.api.store.element.ElementStore
import io.arkitik.clef.workflow.api.usecase.element.main.CreateElementUseCase
import io.arkitik.clef.workflow.api.usecase.element.main.ElementFullDetailsUseCase
import io.arkitik.clef.workflow.api.usecase.element.main.ExecuteActionIntoElementUseCase
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementUseCaseFactoryImpl(
    elementStore: ElementStore,
    elementFlowStore: ElementFlowStore,
    elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
    workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
    actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
    identityAccessValidation: IdentityAccessValidation,
    stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
) : ElementUseCaseFactory {
    override val createElementUseCase =
        CreateElementUseCase(
            elementStore = elementStore,
            elementDomainUseCaseFactory = elementDomainUseCaseFactory,
            workflowDomainUseCaseFactory = workflowDomainUseCaseFactory,
            stageDomainUseCaseFactory = stageDomainUseCaseFactory,
            taskDomainUseCaseFactory = taskDomainUseCaseFactory,
        )
    override val executeActionIntoElementUseCase =
        ExecuteActionIntoElementUseCase(
            elementStore = elementStore,
            elementFlowStore = elementFlowStore,
            elementDomainUseCaseFactory = elementDomainUseCaseFactory,
            identityAccessValidation = identityAccessValidation,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory
        )

    override val elementFullDetailsUseCase =
        ElementFullDetailsUseCase(
            elementDomainUseCaseFactory = elementDomainUseCaseFactory,
            actionDomainUseCaseFactory = actionDomainUseCaseFactory
        )
}
