package io.arkitik.clef.workflow.api.usecase.element.main

import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.task.TaskDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.ElementByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.response.ElementAvailableAction
import io.arkitik.clef.workflow.api.usecase.factory.element.response.ElementDomainDetails
import io.arkitik.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ElementFullDetailsUseCase(
    private val elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
    private val actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
) : ValidationFunctionalUseCase<ElementByKeyRequest, ElementFullDetailsResponse>() {

    override fun ElementByKeyRequest.doProcess(): ElementFullDetailsResponse {
        val element = elementDomainUseCaseFactory.functional {
            findElementByKeyUseCase
        }.process(ElementKeyRequest(key)).response
        val taskActionsResponse = actionDomainUseCaseFactory.functional {
            findTaskActionsUseCase
        }.process(TaskDomainRequest(element.task))

        val actions = taskActionsResponse
            .actions
            .map { action ->
                ElementAvailableAction(
                    uuid = action.uuid,
                    key = action.actionKey,
                    name = action.actionName,
                    listOf())
            }
        return ElementFullDetailsResponse(
            elementUuid = element.uuid,
            elementKey = element.elementKey,
            currentTask = ElementDomainDetails(
                name = element.task.taskName,
                key = element.task.taskKey,
                uuid = element.task.uuid
            ),
            currentStage = ElementDomainDetails(
                name = element.task.stage.stageName,
                key = element.task.stage.stageKey,
                uuid = element.task.stage.uuid
            ),
            currentWorkflow = ElementDomainDetails(
                name = element.task.stage.workflow.workflowName,
                key = element.task.stage.workflow.workflowKey,
                uuid = element.task.stage.workflow.uuid
            ),
            availableActions = actions
        )
    }
}
