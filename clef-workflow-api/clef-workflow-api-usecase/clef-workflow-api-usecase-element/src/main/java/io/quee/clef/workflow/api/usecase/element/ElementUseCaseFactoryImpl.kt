package io.quee.clef.workflow.api.usecase.element

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.element.ElementFlowStore
import io.quee.clef.workflow.api.store.element.ElementStore
import io.quee.clef.workflow.api.usecase.element.main.CreateElementUseCase
import io.quee.clef.workflow.api.usecase.element.main.ElementFullDetailsUseCase
import io.quee.clef.workflow.api.usecase.element.main.ExecuteActionIntoElementUseCase
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ElementByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementUseCaseFactoryImpl(
    elementStore: ElementStore,
    elementFlowStore: ElementFlowStore,
    elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
    workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
    taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
    identityAccessValidation: IdentityAccessValidation,
    stageDomainUseCaseFactory: StageDomainUseCaseFactory,
) : ElementUseCaseFactory {
    override val createElementUseCase: FunctionalUseCase<CreateElementRequest, ViewIdentify> = CreateElementUseCase(
        elementStore,
        elementDomainUseCaseFactory,
        workflowDomainUseCaseFactory
    )
    override val executeActionIntoElementUseCase: FunctionalUseCase<ExecuteActionRequest, SharedResponse> =
        ExecuteActionIntoElementUseCase(
            elementStore,
            elementFlowStore,
            elementDomainUseCaseFactory,
            taskActionDomainUseCaseFactory,
            identityAccessValidation,
            stageDomainUseCaseFactory,
            workflowDomainUseCaseFactory
        )

    override val elementFullDetailsUseCase: FunctionalUseCase<RequestAdapter<ElementByKeyRequest>, ElementFullDetailsResponse> =
        ElementFullDetailsUseCase(elementDomainUseCaseFactory)
}