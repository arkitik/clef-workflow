package io.quee.clef.workflow.api.usecase.action

import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.action.TaskActionStore
import io.quee.clef.workflow.api.usecase.action.main.*
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskActionUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionUseCaseFactoryImpl(
        taskActionStore: TaskActionStore,
        stageTaskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
        taskActionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
        identityStatusValidation: IdentityStatusValidation
) : TaskActionUseCaseFactory {
    override val createTaskActionUseCase: FunctionalUseCase<CreateTaskActionRequest, ViewIdentify> = CreateTaskActionUseCase(
            taskActionStore.identityCreator(),
            taskActionDomainUseCaseFactory,
            stageTaskDomainUseCaseFactory
    )
    override val taskActionDetailsUseCase: FunctionalUseCase<TaskActionRequest, TaskActionDetails> = TaskActionDetailsUseCase(taskActionDomainUseCaseFactory)
    override val enableTaskActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse> = EnableTaskActionUseCase(
            taskActionStore,
            identityStatusValidation,
            taskActionDomainUseCaseFactory
    )
    override val disableTaskActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse> = DisableTaskActionUseCase(
            taskActionStore,
            identityStatusValidation,
            taskActionDomainUseCaseFactory
    )
    override val deleteTaskActionUseCase: FunctionalUseCase<TaskActionRequest, SharedResponse> = DeleteTaskActionUseCase(
            identityStatusValidation,
            taskActionDomainUseCaseFactory
    )
}