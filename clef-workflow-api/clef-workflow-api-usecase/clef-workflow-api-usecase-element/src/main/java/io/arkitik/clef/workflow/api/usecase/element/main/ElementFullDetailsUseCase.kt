package io.arkitik.clef.workflow.api.usecase.element.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.ElementByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.response.ElementAvailableAction
import io.arkitik.clef.workflow.api.usecase.factory.element.response.ElementAvailableActionParameter
import io.arkitik.clef.workflow.api.usecase.factory.element.response.ElementDomainDetails
import io.arkitik.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementFullDetailsUseCase(
    private val elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
) : ValidationFunctionalUseCase<ElementByKeyRequest, ElementFullDetailsResponse>() {

    override fun ElementByKeyRequest.doProcess(): ElementFullDetailsResponse {
        val elementIdentity = elementDomainUseCaseFactory.findElementByKeyAndUuidUseCase
            .run {
                ElementKeyRequest(key)
                    .process()
                    .response
            }
        val actions = elementIdentity.currentTask
            .actions
            .map { action ->
                ElementAvailableAction(action.uuid, action.actionKey, action.actionName,
                    action.parameters.map {
                        ElementAvailableActionParameter(it.parameterKey, it.parameterValue)
                    })
            }
        return ElementFullDetailsResponse(
            elementUuid = elementIdentity.uuid,
            elementKey = elementIdentity.elementKey,
            currentTask = ElementDomainDetails(elementIdentity.currentTask.taskName,
                elementIdentity.currentTask.taskKey,
                elementIdentity.currentTask.uuid),
            currentStage = ElementDomainDetails(elementIdentity.currentStage.stageName,
                elementIdentity.currentStage.stageKey,
                elementIdentity.currentStage.uuid),
            currentWorkflow = ElementDomainDetails(elementIdentity.workflow.workflowName,
                elementIdentity.workflow.workflowKey,
                elementIdentity.workflow.uuid),
            availableActions = actions
        )
    }
}