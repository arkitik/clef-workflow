package io.quee.clef.workflow.api.usecase.stage.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.store.stage.creator.StageIdentityCreator
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddStageToWorkflowRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateStageUseCase(
        private val stageIdentityCreator: StageIdentityCreator,
        private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
        private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory
) : ValidationFunctionalUseCase<CreateStageRequest, ViewIdentify>() {
    override fun CreateStageRequest.extraValidation() {
        stageDomainUseCaseFactory.validateStageExistenceUseCase
                .run {
                    ExistByKeyRequest.instance(stageKey)
                            .execute()
                }
    }

    override fun CreateStageRequest.realProcess(): ViewIdentify {
        val workflowIdentity = workflowDomainUseCaseFactory.findWorkflowByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(workflow.key, workflow.uuid)
                            .process()
                            .response
                }
        val stageIdentity = stageIdentityCreator
                .run {
                    stageKey.stageKey()
                    stageName.stageName()
                    create()
                }
        workflowDomainUseCaseFactory.addStageToWorkflowUseCase
                .run {
                    AddStageToWorkflowRequest.instance(workflowIdentity, stageIdentity, initialStage)
                }
        return ViewIdentify(stageIdentity.uuid, stageIdentity.stageKey)
    }
}