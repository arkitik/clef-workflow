package io.quee.clef.workflow.api.usecase.factory.domain

import io.arkitik.radix.develop.usecase.CommandUseCase
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.factory.UseCaseFactory
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddTaskToStageRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.quee.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyAndUuidRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageDomainUseCaseFactory : UseCaseFactory {
    val findStageByKeyAndUuidUseCase: FunctionalUseCase<FindDomainByKeyAndUuidRequest, ResponseAdapter<StageIdentity>>
    val findStageByTaskUseCase: FunctionalUseCase<RequestAdapter<StageTaskIdentity>, ResponseAdapter<StageIdentity>>
    val validateStageExistenceUseCase: CommandUseCase<ExistByKeyRequest>
    val addTaskToStageUseCase: CommandUseCase<AddTaskToStageRequest>
    val deleteAllStagesUseCase: CommandUseCase<RequestAdapter<List<StageIdentity>>>
}