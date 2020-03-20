package io.quee.clef.workflow.api.usecase.task.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.store.task.creator.StageTaskCreator
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddTaskToStageRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateTaskUseCase(
        private val stageTaskCreator: StageTaskCreator,
        private val stageTaskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
        private val stageDomainUseCaseFactory: StageDomainUseCaseFactory
) : ValidationFunctionalUseCase<CreateTaskRequest, ViewIdentify>() {
    override fun CreateTaskRequest.extraValidation() {
        stageTaskDomainUseCaseFactory.validateStageTaskExistenceUseCase
                .run {
                    ExistByKeyRequest.instance(taskKey)
                            .execute()
                }
    }

    override fun CreateTaskRequest.realProcess(): ViewIdentify {
        val stageIdentity = stageDomainUseCaseFactory.findStageByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(stage.key, stage.uuid)
                            .process()
                            .response
                }
        val stageTaskIdentity = stageTaskCreator
                .run {
                    taskKey.taskKey()
                    taskName.taskName()
                    create()
                }
        stageDomainUseCaseFactory.addTaskToStageUseCase
                .run {
                    AddTaskToStageRequest.instance(stageTaskIdentity, stageIdentity, initialTask)
                            .execute()
                }
        return ViewIdentify(stageTaskIdentity.uuid, stageTaskIdentity.taskKey)
    }
}