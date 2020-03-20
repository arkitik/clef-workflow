package io.quee.clef.workflow.api.usecase.element.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.shared.model.Identity
import io.quee.clef.workflow.api.common.error.ElementResponses
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.element.ElementFlowStore
import io.quee.clef.workflow.api.store.element.ElementStore
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.FindElementByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ExecuteActionIntoElementUseCase(
        private val elementStore: ElementStore,
        private val elementFlowStore: ElementFlowStore,
        private val elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
        private val taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
        private val identityAccessValidation: IdentityAccessValidation
) : ValidationFunctionalUseCase<ExecuteActionRequest, SharedResponse>() {

    override fun ExecuteActionRequest.realProcess(): SharedResponse {
        val elementIdentity = elementDomainUseCaseFactory.findElementByKeyAndUuidUseCase
                .run {
                    FindElementByKeyAndUuidRequest.instance(element.key, element.uuid)
                            .process()
                            .response
                }
        val taskActionIdentity = taskActionIdentity(elementIdentity)

        taskActionIdentity.destinationTask.validate()
        val elementFlowIdentity = elementFlowStore.identityCreator()
                .run {
                    elementIdentity.currentTask.fromTask()
                    taskActionIdentity.action()
                    taskActionIdentity.destinationTask.toTask()
                    create()
                }
        elementStore.run {
            elementIdentity.identityUpdater()
                    .run {
                        taskActionIdentity.destinationTask.currentTask()
                        elementFlowIdentity.addFlow()
                        update().save()
                    }
        }
        return ElementResponses.ACTION_EXECUTED_SUCCESSFULLY
    }

    private fun ExecuteActionRequest.taskActionIdentity(elementIdentity: ElementIdentity): TaskActionIdentity {
        val actionIdentity = taskActionDomainUseCaseFactory.findTaskActionByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(action.key, action.uuid)
                            .process()
                            .response
                }
        return elementIdentity.currentTask.actions.firstOrNull {
            it.actionKey == actionIdentity.actionKey && it.uuid == actionIdentity.uuid
        } ?: throw NotAcceptableException(ElementResponses.Errors.ACTION_CANT_EXECUTE)
    }

    private fun Identity.validate() {
        identityAccessValidation.run {
            identityStatus.validate()
        }
    }
}