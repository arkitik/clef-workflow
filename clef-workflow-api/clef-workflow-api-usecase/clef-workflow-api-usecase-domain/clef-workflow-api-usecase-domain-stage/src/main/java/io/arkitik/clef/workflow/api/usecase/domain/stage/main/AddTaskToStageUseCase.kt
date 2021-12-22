package io.arkitik.clef.workflow.api.usecase.domain.stage.main

import io.arkitik.radix.develop.shared.exception.NotAcceptableException
import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.arkitik.clef.workflow.api.common.error.StageResponses
import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.AddTaskToStageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class AddTaskToStageUseCase(
    private val stageStore: StageStore,
    private val identityAccessValidation: IdentityAccessValidation,
) : ValidationCommandUseCase<AddTaskToStageRequest>() {
    override fun AddTaskToStageRequest.doBefore() {
        identityAccessValidation.run {
            stageIdentity.identityStatus.validate()
        }
        if (stageIdentity.initialTask != null && initialTask) {
            throw NotAcceptableException(StageResponses.Errors.INITIAL_TASK_HAS_BEEN_ADDED_BEFORE)
        }
    }

    override fun AddTaskToStageRequest.doExecute() {
        stageStore.run {
            val updater = stageIdentity.identityUpdater()
            updater.run {
                if (initialTask) {
                    stageTaskIdentity.initialTask()
                } else {
                    stageTaskIdentity.addTask()
                }
                updater.update()
                    .save()
            }
        }
    }
}