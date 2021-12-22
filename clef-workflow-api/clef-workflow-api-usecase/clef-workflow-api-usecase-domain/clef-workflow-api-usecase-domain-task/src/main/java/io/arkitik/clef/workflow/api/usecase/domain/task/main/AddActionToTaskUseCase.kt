package io.arkitik.clef.workflow.api.usecase.domain.task.main

import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.arkitik.clef.workflow.api.function.shared.IdentityAccessValidation
import io.arkitik.clef.workflow.api.store.task.StageTaskStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.AddActionToTaskRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **16**, **Mon Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class AddActionToTaskUseCase(
    private val stageTaskStore: StageTaskStore,
    private val identityAccessValidation: IdentityAccessValidation,
) : ValidationCommandUseCase<AddActionToTaskRequest>() {
    override fun AddActionToTaskRequest.doBefore() {
        identityAccessValidation.run {
            sourceStageTaskIdentity.identityStatus.validate()
        }
    }

    override fun AddActionToTaskRequest.doExecute() {
        stageTaskStore.run {
            sourceStageTaskIdentity.identityUpdater()
                .run {
                    taskActionIdentity.addAction()
                    update().save()
                }
        }
    }
}