package io.quee.clef.workflow.api.usecase.domain.action.main

import io.quee.api.develop.action.usecase.validation.ValidationCommandUseCase
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.store.action.TaskActionStore

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DeleteAllActionsUseCase(private val actionStore: TaskActionStore) : ValidationCommandUseCase<RequestAdapter<List<TaskActionIdentity>>>() {
    override fun RequestAdapter<List<TaskActionIdentity>>.realExecute() {
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