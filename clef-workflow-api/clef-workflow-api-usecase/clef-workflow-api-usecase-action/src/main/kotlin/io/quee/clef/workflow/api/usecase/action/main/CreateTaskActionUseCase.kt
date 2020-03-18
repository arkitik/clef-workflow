package io.quee.clef.workflow.api.usecase.action.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.action.creator.TaskActionCreator
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddActionToTaskRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.DomainUuidAndKey
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateTaskActionUseCase(
        private val taskActionCreator: TaskActionCreator,
        private val taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
        private val stageTaskDomainUseCaseFactory: StageTaskDomainUseCaseFactory
) : ValidationFunctionalUseCase<CreateTaskActionRequest, ViewIdentify>() {
    override fun CreateTaskActionRequest.extraValidation() {
        taskActionDomainUseCaseFactory.validateTaskActionExistenceUseCase
                .run {
                    ExistByKeyRequest.instance(actionKey).execute()
                }
    }

    override fun CreateTaskActionRequest.realProcess(): ViewIdentify {
        val sourceTaskIdentify = findTaskIdentify(sourceTask)
        val destinationTaskIdentify = findTaskIdentify(destinationTask)
        val taskAction = taskActionCreator
                .run {
                    actionDescription.actionDescription()
                    actionKey.actionKey()
                    actionName.actionName()
                    destinationTaskIdentify.destinationTask()
                    create()
                }
        stageTaskDomainUseCaseFactory.addActionToTaskUseCase
                .run {
                    AddActionToTaskRequest.instance(sourceTaskIdentify, taskAction)
                            .execute()
                }
        return ViewIdentify(taskAction.uuid, taskAction.actionKey)
    }

    private fun findTaskIdentify(taskIdentify: DomainUuidAndKey): StageTaskIdentity {
        return stageTaskDomainUseCaseFactory.findStageTaskByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(taskIdentify.key, taskIdentify.uuid)
                            .process()
                            .response
                }
    }
}