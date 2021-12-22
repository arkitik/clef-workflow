package io.arkitik.clef.workflow.api.usecase.task

import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.clef.workflow.api.common.response.SharedResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
import io.arkitik.clef.workflow.api.store.task.StageTaskStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse
import io.arkitik.clef.workflow.api.usecase.task.main.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class TaskUseCaseFactoryImpl(
    stageTaskStore: StageTaskStore,
    stageTaskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
    identityStatusValidation: IdentityStatusValidation,
    stageDomainUseCaseFactory: StageDomainUseCaseFactory,
) : TaskUseCaseFactory {
    override val createTaskUseCase: FunctionalUseCase<CreateTaskRequest, ViewIdentify> = CreateTaskUseCase(
        stageTaskStore.identityCreator(),
        stageTaskDomainUseCaseFactory,
        stageDomainUseCaseFactory
    )
    override val taskDetailsUseCase: FunctionalUseCase<TaskRequest, TaskDetailsResponse> =
        TaskDetailsUseCase(stageTaskDomainUseCaseFactory)
    override val enableTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse> =
        EnableTaskUseCase(stageTaskStore, identityStatusValidation, stageTaskDomainUseCaseFactory)
    override val disableTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse> =
        DisableTaskUseCase(stageTaskStore, identityStatusValidation, stageTaskDomainUseCaseFactory)
    override val deleteTaskUseCase: FunctionalUseCase<TaskRequest, SharedResponse> =
        DeleteTaskUseCase(identityStatusValidation, stageTaskDomainUseCaseFactory)
}