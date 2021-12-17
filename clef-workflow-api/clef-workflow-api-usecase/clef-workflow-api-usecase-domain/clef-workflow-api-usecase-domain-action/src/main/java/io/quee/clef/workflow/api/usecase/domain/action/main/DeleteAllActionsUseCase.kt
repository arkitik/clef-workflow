package io.quee.clef.workflow.api.usecase.domain.action.main

import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.store.action.TaskActionStore

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DeleteAllActionsUseCase(private val actionStore: TaskActionStore) :
    ValidationCommandUseCase<RequestAdapter<List<TaskActionIdentity>>>() {
    override fun RequestAdapter<List<TaskActionIdentity>>.doExecute() {
        val items = request.map {
            actionStore.run {
                it.identityUpdater()
                    .delete()
                    .update()
            }
        }
        actionStore.run {
            items.save()
        }
    }
}