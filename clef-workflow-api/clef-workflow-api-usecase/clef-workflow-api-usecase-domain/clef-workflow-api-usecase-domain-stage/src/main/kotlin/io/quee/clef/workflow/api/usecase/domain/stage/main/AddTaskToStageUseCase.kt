package io.quee.clef.workflow.api.usecase.domain.stage.main

import io.quee.api.develop.action.usecase.validation.ValidationCommandUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.clef.workflow.api.common.error.StageResponses
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.stage.StageStore
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddTaskToStageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class AddTaskToStageUseCase(
        private val stageStore: StageStore,
        private val identityAccessValidation: IdentityAccessValidation
) : ValidationCommandUseCase<AddTaskToStageRequest>() {
    override fun AddTaskToStageRequest.extraValidation() {
        identityAccessValidation.run {
            stageIdentity.identityStatus.validate()
        }
        if (stageIdentity.initialTask != null && initialTask) {
            throw NotAcceptableException(StageResponses.Errors.INITIAL_TASK_HAS_BEEN_ADDED_BEFORE)
        }
    }

    override fun AddTaskToStageRequest.realExecute() {
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