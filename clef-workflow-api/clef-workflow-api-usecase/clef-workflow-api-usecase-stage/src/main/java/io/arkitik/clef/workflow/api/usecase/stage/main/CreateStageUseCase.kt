package io.arkitik.clef.workflow.api.usecase.stage.main

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.store.stage.creator.StageIdentityCreator
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.AddStageToWorkflowRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class CreateStageUseCase(
    private val stageIdentityCreator: StageIdentityCreator,
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : ValidationFunctionalUseCase<CreateStageRequest, ViewIdentify>() {
    override fun CreateStageRequest.doBefore() {
        stageDomainUseCaseFactory.validateStageExistenceUseCase
            .run {
                ExistByKeyRequest(stageKey)
                    .execute()
            }
    }

    override fun CreateStageRequest.doProcess(): ViewIdentify {
        val workflowIdentity = workflowDomainUseCaseFactory.findWorkflowByKeyAndUuidUseCase
            .run {
                FindDomainByKeyAndUuidRequest(workflow.key, false)
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
                AddStageToWorkflowRequest(workflowIdentity, stageIdentity, initialStage)
                    .execute()
            }
        return ViewIdentify(stageIdentity.uuid, stageIdentity.stageKey)
    }
}