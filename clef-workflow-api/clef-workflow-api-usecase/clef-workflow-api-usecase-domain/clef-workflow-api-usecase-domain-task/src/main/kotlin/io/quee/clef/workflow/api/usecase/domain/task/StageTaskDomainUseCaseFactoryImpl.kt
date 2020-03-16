package io.quee.clef.workflow.api.usecase.domain.task

import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.api.develop.usecase.type.CommandUseCase
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.task.StageTaskStore
import io.quee.clef.workflow.api.usecase.domain.task.main.AddActionToTaskUseCase
import io.quee.clef.workflow.api.usecase.domain.task.main.FindStageByKeyAndUuidUseCase
import io.quee.clef.workflow.api.usecase.domain.task.main.ValidateStageTaskExistenceUseCase
import io.quee.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddActionToTaskRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageTaskDomainUseCaseFactoryImpl(
        private val stageTaskStore: StageTaskStore,
        private val identityAccessValidation: IdentityAccessValidation
) : StageTaskDomainUseCaseFactory {
    override val findStageTaskByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<StageTaskIdentity>> =
            FindStageByKeyAndUuidUseCase(stageTaskStore.storeQuery, identityAccessValidation)
    override val validateStageTaskExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
            ValidateStageTaskExistenceUseCase(stageTaskStore.storeQuery)
    override val addActionToTaskUseCase: CommandUseCase<AddActionToTaskRequest> =
            AddActionToTaskUseCase(stageTaskStore, identityAccessValidation)
}