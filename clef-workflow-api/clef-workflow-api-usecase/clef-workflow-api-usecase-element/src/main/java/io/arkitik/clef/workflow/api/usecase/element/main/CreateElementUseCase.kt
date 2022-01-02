package io.arkitik.clef.workflow.api.usecase.element.main

import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.store.element.ElementStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.stage.StageDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.workflow.WorkflowDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.CreateElementRequest
import io.arkitik.radix.develop.usecase.adapter.adapterProcess
import io.arkitik.radix.develop.usecase.command
import io.arkitik.radix.develop.usecase.execute
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class CreateElementUseCase(
    private val elementStore: ElementStore,
    private val elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    private val taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
) : ValidationFunctionalUseCase<CreateElementRequest, ViewIdentify>() {

    override fun CreateElementRequest.doBefore() {
        elementDomainUseCaseFactory command {
            validateStageExistenceUseCase
        } execute ElementKeyRequest(elementKey)
    }

    override fun CreateElementRequest.doProcess(): ViewIdentify {
        val workflow = workflowDomainUseCaseFactory functional {
            findWorkflowByKeyUseCase
        } adapterProcess FindDomainByKeyRequest(workflow.key, false)
        val stage = stageDomainUseCaseFactory.functional {
            findWorkflowInitialStageUseCase
        }.process(WorkflowDomainRequest(workflow)).response

        val task = taskDomainUseCaseFactory.functional {
            findStageInitialTaskUseCase
        }.process(StageDomainRequest(stage)).response

        val elementIdentity = elementStore.run {
            identityCreator()
                .run {
                    elementKey.elementKey()
                    task.currentTask()
                    create().save()
                }
        }
        return ViewIdentify(elementIdentity.uuid, elementIdentity.elementKey)
    }
}
