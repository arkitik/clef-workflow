package io.quee.clef.workflow.api.usecase.element.main

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.radix.develop.usecase.adapter.adapterProcess
import io.arkitik.radix.develop.usecase.command
import io.arkitik.radix.develop.usecase.execute
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.error.StageResponses
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.store.element.ElementStore
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest
import io.quee.clef.workflow.api.usecase.factory.element.request.CreateElementRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateElementUseCase(
    private val elementStore: ElementStore,
    private val elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : ValidationFunctionalUseCase<CreateElementRequest, ViewIdentify>() {

    override fun CreateElementRequest.doBefore() {
        elementDomainUseCaseFactory command {
            validateStageExistenceUseCase
        } execute ElementKeyRequest(elementKey)
    }

    override fun CreateElementRequest.doProcess(): ViewIdentify {
        val workflowIdentity = workflowDomainUseCaseFactory functional {
            findWorkflowByKeyAndUuidUseCase
        } adapterProcess FindDomainByKeyAndUuidRequest(workflow.key, false)

        if (workflowIdentity.initialStage == null)
            throw NotAcceptableException(WorkflowResponses.Errors.WORKFLOW_DOES_NOT_HAVE_INITIAL_STAGE)
        if (workflowIdentity.initialStage?.initialTask == null)
            throw NotAcceptableException(StageResponses.Errors.STAGE_DOES_NOT_HAVE_INITIAL_TASK)
        val elementIdentity = elementStore.run {
            identityCreator()
                .run {
                    elementKey.elementKey()
                    workflowIdentity.workflow()
                    workflowIdentity.initialStage?.currentStage()
                    workflowIdentity.initialStage?.initialTask?.currentTask()
                    create().save()
                }
        }
        return ViewIdentify(elementIdentity.uuid, elementIdentity.elementKey)
    }
}