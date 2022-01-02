package io.arkitik.clef.workflow.api.usecase.stage.main

import io.arkitik.clef.workflow.api.common.error.StageResponses
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.store.stage.InitialStageStore
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.WorkflowDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.arkitik.radix.develop.shared.ext.unprocessableEntity
import io.arkitik.radix.develop.store.storeCreator
import io.arkitik.radix.develop.usecase.command
import io.arkitik.radix.develop.usecase.execute
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class CreateStageUseCase(
    private val stageStore: StageStore,
    private val initialStageStore: InitialStageStore,
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    private val workflowDomainUseCaseFactory: WorkflowDomainUseCaseFactory,
) : ValidationFunctionalUseCase<CreateStageRequest, ViewIdentify>() {
    override fun CreateStageRequest.doBefore() {
        stageDomainUseCaseFactory.command {
            validateStageExistenceUseCase
        } execute ExistByKeyRequest(stageKey)
    }

    override fun CreateStageRequest.doProcess(): ViewIdentify {
        val workflowIdentity = workflowDomainUseCaseFactory.findWorkflowByKeyUseCase
            .run {
                FindDomainByKeyRequest(workflow.key, false)
                    .process()
                    .response
            }
        val stageIdentity = with(stageStore) {
            storeCreator(identityCreator()) {
                stageKey.stageKey()
                stageName.stageName()
                workflowIdentity.workflow()
                create()
            }.save()
        }
        takeIf { initialStage }?.let {
            with(initialStageStore) {
                storeQuery.existsByWorkflow(workflowIdentity)
                    .takeIf { it }?.let {
                        throw StageResponses.Errors.INITIAL_STAGE_HAS_BEEN_ADDED_BEFORE.unprocessableEntity()
                    }
                storeCreator(identityCreator()) {
                    stageIdentity.stage()
                    workflowIdentity.workflow()
                    create()
                }.save()
            }
        }
        return ViewIdentify(stageIdentity.uuid, stageIdentity.stageKey)
    }
}
