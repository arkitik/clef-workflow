package io.quee.clef.workflow.api.usecase.action.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionParameter
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.action.TaskActionStore
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddActionToTaskRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.DomainUuidAndKey
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionParamRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateTaskActionUseCase(
        private val taskActionStore: TaskActionStore,
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
        val parameters = collectParams()
        val taskAction = taskActionStore.identityCreator()
                .run {
                    actionDescription.actionDescription()
                    actionKey.actionKey()
                    actionName.actionName()
                    destinationTaskIdentify.destinationTask()
                    parameters.forEach {
                        it.addParam()
                    }
                    create()
                }
        stageTaskDomainUseCaseFactory.addActionToTaskUseCase
                .run {
                    AddActionToTaskRequest.instance(sourceTaskIdentify, taskAction)
                            .execute()
                }
        return ViewIdentify(taskAction.uuid, taskAction.actionKey)
    }

    private fun CreateTaskActionRequest.collectParams(): List<TaskActionParameter> {
        return parameters.map {
            it.toParameter()
        }
    }

    private fun TaskActionParamRequest.toParameter(): TaskActionParameter {
        return taskActionStore.taskActionParameterCreator()
                .run {
                    parameterKey.parameterKey()
                    parameterValue.parameterValue()
                    create()
                }
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