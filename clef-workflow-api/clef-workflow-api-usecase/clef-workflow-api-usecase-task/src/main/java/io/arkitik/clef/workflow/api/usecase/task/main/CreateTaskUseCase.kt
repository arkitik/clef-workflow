package io.arkitik.clef.workflow.api.usecase.task.main

import io.arkitik.clef.workflow.api.common.error.StageTaskResponses
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.store.task.InitialTaskStore
import io.arkitik.clef.workflow.api.store.task.TaskStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest
import io.arkitik.radix.develop.shared.ext.unprocessableEntity
import io.arkitik.radix.develop.store.storeCreator
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class CreateTaskUseCase(
    private val taskStore: TaskStore,
    private val initialTaskStore: InitialTaskStore,
    private val taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
) : ValidationFunctionalUseCase<CreateTaskRequest, ViewIdentify>() {
    override fun CreateTaskRequest.doBefore() {
        taskDomainUseCaseFactory.validateTaskExistenceUseCase
            .run {
                ExistByKeyRequest(taskKey)
                    .execute()
            }
    }

    override fun CreateTaskRequest.doProcess(): ViewIdentify {
        val stage = stageDomainUseCaseFactory.functional {
            findStageByKeyUseCase
        }.process(FindDomainByKeyRequest(stage.key, false)).response
        val taskIdentity = with(taskStore) {
            storeCreator(identityCreator()) {
                taskKey.taskKey()
                taskName.taskName()
                stage.stage()
                create()
            }.save()
        }
        takeIf { initialTask }?.let {
            with(initialTaskStore) {
                storeQuery.existsByStage(stage)
                    .takeIf { it }?.let {
                        throw StageTaskResponses.Errors.INITIAL_TASK_HAS_BEEN_ADDED_BEFORE.unprocessableEntity()
                    }

                storeCreator(identityCreator()) {
                    taskIdentity.task()
                    stage.stage()
                    create()
                }.save()
            }
        }
        return ViewIdentify(taskIdentity.uuid, taskIdentity.taskKey)
    }
}
