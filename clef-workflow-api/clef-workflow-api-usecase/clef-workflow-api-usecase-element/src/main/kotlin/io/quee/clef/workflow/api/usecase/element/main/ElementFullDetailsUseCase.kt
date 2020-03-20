package io.quee.clef.workflow.api.usecase.element.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.FindElementByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ElementByUuidAndKey
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementAvailableAction
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementDomainDetails
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementFullDetailsUseCase(
        private val elementDomainUseCaseFactory: ElementDomainUseCaseFactory
) : ValidationFunctionalUseCase<RequestAdapter<ElementByUuidAndKey>, ElementFullDetailsResponse>() {

    override fun RequestAdapter<ElementByUuidAndKey>.realProcess(): ElementFullDetailsResponse {
        val elementIdentity = elementDomainUseCaseFactory.findElementByKeyAndUuidUseCase
                .run {
                    FindElementByKeyAndUuidRequest.instance(request.key, request.uuid)
                            .process()
                            .response
                }
        val actions = elementIdentity.currentTask
                .actions
                .map {
                    ElementAvailableAction(it.uuid, it.actionKey, it.actionName)
                }
        return ElementFullDetailsResponse(
                elementUuid = elementIdentity.uuid,
                elementKey = elementIdentity.elementKey,
                currentTask = ElementDomainDetails(elementIdentity.currentTask.taskName, elementIdentity.currentTask.taskKey, elementIdentity.currentTask.uuid),
                currentStage = ElementDomainDetails(elementIdentity.currentStage.stageName, elementIdentity.currentStage.stageKey, elementIdentity.currentStage.uuid),
                currentWorkflow = ElementDomainDetails(elementIdentity.workflow.workflowName, elementIdentity.workflow.workflowKey, elementIdentity.workflow.uuid),
                availableActions = actions
        )
    }
}