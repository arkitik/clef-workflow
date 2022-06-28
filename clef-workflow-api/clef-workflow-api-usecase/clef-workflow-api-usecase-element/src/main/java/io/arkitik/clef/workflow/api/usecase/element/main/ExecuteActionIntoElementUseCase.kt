package io.arkitik.clef.workflow.api.usecase.element.main

import io.arkitik.clef.workflow.api.common.error.ElementResponses
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.store.element.ElementFlowStore
import io.arkitik.clef.workflow.api.store.element.ElementStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
import io.arkitik.radix.develop.shared.ext.unprocessableEntity
import io.arkitik.radix.develop.store.storeUpdater
import io.arkitik.radix.develop.usecase.adapter.adapterProcess
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ExecuteActionIntoElementUseCase(
    private val elementStore: ElementStore,
    private val elementFlowStore: ElementFlowStore,
    private val elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
    private val actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
    private val identityAccessValidation: IdentityAccessValidation,
) : ValidationFunctionalUseCase<ExecuteActionRequest, SharedResponse>() {

    override fun ExecuteActionRequest.doProcess(): SharedResponse {
        val element = elementDomainUseCaseFactory functional {
            findElementByKeyUseCase
        } adapterProcess ElementKeyRequest(element.key)

        val actionToBeExecuted = findAction()
        element.validateActionAvailability(actionToBeExecuted)
        val destinationTask = actionToBeExecuted.destinationTask.also {
            identityAccessValidation.run {
                it.identityStatus.validate()
            }
        }
        val destinationStage = destinationTask.stage.also {
            identityAccessValidation.run {
                it.identityStatus.validate()
            }
        }
        val destinationWorkflow = destinationStage.workflow
        identityAccessValidation.run {
            destinationWorkflow.identityStatus.validate()
        }

        val elementFlowIdentity = elementFlowStore.identityCreator()
            .run {
                element.task.stage.workflow.fromWorkflow()
                destinationWorkflow.toWorkflow()
                element.task.stage.fromStage()
                destinationStage.toStage()
                element.task.fromTask()
                actionToBeExecuted.action()
                destinationTask.toTask()
                element.element()
                create()
            }
        elementStore.run {
            storeUpdater(element.identityUpdater()) {
                destinationTask.task()
                update()
            }.save()
        }
        elementFlowStore.run {
            elementFlowIdentity.save()
        }
        return ElementResponses.ACTION_EXECUTED_SUCCESSFULLY
    }

    private fun ExecuteActionRequest.findAction() =
        actionDomainUseCaseFactory functional {
            findActionByKeyUseCase
        } adapterProcess FindDomainByKeyRequest(action.key, false)

    private fun ElementIdentity.validateActionAvailability(action: ActionIdentity) {
        if (action.sourceTask.uuid != task.uuid) {
            throw ElementResponses.Errors.CANT_EXECUTE_ACTION.unprocessableEntity()
        }
    }
}
