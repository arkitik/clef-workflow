package io.quee.clef.workflow.api.usecase.action.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.clef.workflow.api.common.error.TaskActionResponses
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.action.TaskActionStore
import io.quee.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateTaskActionUseCase(
        private val taskActionStore: TaskActionStore,
        private val taskDomainUseCaseFactory: TaskDomainUseCaseFactory
) : ValidationFunctionalUseCase<CreateTaskActionRequest, ViewIdentify>() {
    override fun CreateTaskActionRequest.extraValidation() {
        if (taskActionStore.storeQuery.existByKey(taskKey))
            throw NotAcceptableException(TaskActionResponses.Errors.DUPLICATE_TASK_ACTION_ERROR)
    }

    override fun CreateTaskActionRequest.realProcess(): ViewIdentify {
        val sourceTaskIdentify = findTaskIdentify(sourceTask)
        val destinationTaskIdentify = findTaskIdentify(destinationTask)
        val taskAction = taskActionStore.run {
            identityCreator()
                    .run {
                        taskDescription.taskDescription()
                        taskKey.taskKey()
                        taskName.taskName()
                        sourceTaskIdentify.sourceTask()
                        destinationTaskIdentify.destinationTask()
                        create().save()
                    }
        }
        return ViewIdentify(taskAction.uuid, taskAction.taskKey)
    }

    private fun findTaskIdentify(taskIdentify: ViewIdentify): StageTaskIdentity {
        return taskDomainUseCaseFactory.findStageTaskByKeyAndUuidUseCase
                .run {
                    FindDomainByKeyAndUuidRequest.instance(taskIdentify.key, taskIdentify.uuid)
                            .process()
                            .response
                }
    }
}