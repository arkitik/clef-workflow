package io.quee.clef.workflow.api.usecase.task

import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.task.StageTaskStore
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse
import io.quee.clef.workflow.api.usecase.task.main.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskUseCaseFactoryImpl(
        stageTaskStore: StageTaskStore,
        stageTaskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
        identityStatusValidation: IdentityStatusValidation,
        stageDomainUseCaseFactory: StageDomainUseCaseFactory
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