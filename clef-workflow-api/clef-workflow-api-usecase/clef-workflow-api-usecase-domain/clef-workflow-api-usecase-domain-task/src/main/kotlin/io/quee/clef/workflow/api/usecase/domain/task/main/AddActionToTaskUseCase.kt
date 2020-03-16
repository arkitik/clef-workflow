package io.quee.clef.workflow.api.usecase.domain.task.main

import io.quee.api.develop.action.usecase.validation.ValidationCommandUseCase
import io.quee.clef.workflow.api.function.shared.IdentityAccessValidation
import io.quee.clef.workflow.api.store.task.StageTaskStore
import io.quee.clef.workflow.api.usecase.factory.domain.request.AddActionToTaskRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class AddActionToTaskUseCase(
        private val stageTaskStore: StageTaskStore,
        private val identityAccessValidation: IdentityAccessValidation
) : ValidationCommandUseCase<AddActionToTaskRequest>() {
    override fun AddActionToTaskRequest.extraValidation() {
        identityAccessValidation.run {
            sourceStageTaskIdentity.identityStatus.validate()
        }
    }

    override fun AddActionToTaskRequest.realExecute() {
        stageTaskStore.run {
            sourceStageTaskIdentity.identityUpdater()
                    .run {
                        taskActionIdentity.addAction()
                        update().save()
                    }
        }
    }
}