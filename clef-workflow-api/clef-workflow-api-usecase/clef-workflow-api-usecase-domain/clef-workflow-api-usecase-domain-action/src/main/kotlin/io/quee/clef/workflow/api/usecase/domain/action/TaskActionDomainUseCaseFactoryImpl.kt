package io.quee.clef.workflow.api.usecase.domain.action

import io.quee.api.develop.usecase.model.ResponseAdapter
import io.quee.api.develop.usecase.type.CommandUseCase
import io.quee.api.develop.usecase.type.FunctionalUseCase
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.action.query.TaskActionStoreQuery
import io.quee.clef.workflow.api.usecase.domain.action.main.FindTaskActionByKeyAndUuidUseCase
import io.quee.clef.workflow.api.usecase.domain.action.main.ValidateTaskActionExistenceUseCase
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionDomainUseCaseFactoryImpl(
        taskActionStoreQuery: TaskActionStoreQuery,
        identityAccessValidation: IdentityAccessValidation
) : TaskActionDomainUseCaseFactory {
    override val findTaskActionByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<TaskActionIdentity>> =
            FindTaskActionByKeyAndUuidUseCase(taskActionStoreQuery, identityAccessValidation)
    override val validateTaskActionExistenceUseCase: CommandUseCase<ExistByKeyRequest> =
            ValidateTaskActionExistenceUseCase(taskActionStoreQuery)
}