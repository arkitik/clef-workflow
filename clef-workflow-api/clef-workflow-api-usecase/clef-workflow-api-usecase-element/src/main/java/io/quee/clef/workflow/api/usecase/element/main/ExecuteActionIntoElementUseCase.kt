package io.quee.clef.workflow.api.usecase.element.main

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.adapterProcess
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.error.ElementResponses
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.element.ElementFlowStore
import io.quee.clef.workflow.api.store.element.ElementStore
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest
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
    private val identityAccessValidation: IdentityAccessValidation,
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : ValidationFunctionalUseCase<ExecuteActionRequest, SharedResponse>() {

    override fun ExecuteActionRequest.doProcess(): SharedResponse {
        val elementIdentity = elementDomainUseCaseFactory functional {
            findElementByKeyAndUuidUseCase
        } adapterProcess ElementKeyRequest(element.key)
        val taskActionIdentity = taskActionIdentity(elementIdentity)
        val destinationTask = taskActionIdentity.destinationTask
        identityAccessValidation.run {
            destinationTask.identityStatus.validate()
        }
        val destinationStage = destinationTask.findDestinationStage()
        identityAccessValidation.run {
            destinationStage.identityStatus.validate()
        }
        val destinationWorkflow = destinationStage.findDestinationWorkflow()
        identityAccessValidation.run {
            destinationWorkflow.identityStatus.validate()
        }

        val elementFlowIdentity = elementFlowStore.identityCreator()
            .run {
                elementIdentity.workflow.fromWorkflow()
                destinationWorkflow.toWorkflow()
                elementIdentity.currentStage.fromStage()
                destinationStage.toStage()
                elementIdentity.currentTask.fromTask()
                taskActionIdentity.action()
                destinationTask.toTask()
                create()
            }
        elementStore.run {
            elementIdentity.identityUpdater()
                .run {
                    destinationStage.currentStage()
                    destinationTask.currentTask()
                    elementFlowIdentity.addFlow()
                    destinationWorkflow.currentWorkflow()
                    update().save()
                }
        }
        return ElementResponses.ACTION_EXECUTED_SUCCESSFULLY
    }

    private fun StageTaskIdentity.findDestinationStage(): StageIdentity {
        stageDomainUseCaseFactory.findStageByTaskUseCase.run {
            return RequestAdapter(this@findDestinationStage).process()
                .response
        }
    }

    private fun StageIdentity.findDestinationWorkflow(): WorkflowIdentity {
        workflowDomainUseCaseFactory.findWorkflowByStageUseCase.run {
            return RequestAdapter(this@findDestinationWorkflow).process()
                .response
        }
    }

    private fun ExecuteActionRequest.taskActionIdentity(elementIdentity: ElementIdentity): TaskActionIdentity {
        val actionIdentity =
            taskActionDomainUseCaseFactory functional {
                findTaskActionByKeyAndUuidUseCase
            } adapterProcess FindDomainByKeyAndUuidRequest(action.key, false)

        return elementIdentity.currentTask.actions.firstOrNull {
            it.actionKey == actionIdentity.actionKey && it.uuid == actionIdentity.uuid
        } ?: throw NotAcceptableException(ElementResponses.Errors.ACTION_CANT_EXECUTE)
    }
}