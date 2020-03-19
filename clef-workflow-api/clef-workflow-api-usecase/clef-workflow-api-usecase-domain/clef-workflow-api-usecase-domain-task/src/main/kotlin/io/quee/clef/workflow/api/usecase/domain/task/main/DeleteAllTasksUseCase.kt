package io.quee.clef.workflow.api.usecase.domain.task.main

import io.quee.api.develop.action.usecase.validation.ValidationCommandUseCase
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.task.StageTaskStore
import io.quee.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import java.util.function.Consumer

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DeleteAllTasksUseCase(
        private val stageTaskStore: StageTaskStore,
        private val actionDomainUseCaseFactory: TaskActionDomainUseCaseFactory
) : ValidationCommandUseCase<RequestAdapter<List<StageTaskIdentity>>>() {
    override fun RequestAdapter<List<StageTaskIdentity>>.realExecute() {
        val items = ArrayList(request.map {
            stageTaskStore.run {
                it.identityUpdater()
                        .delete()
                        .update()
            }
        })
        stageTaskStore.run {
            items.save()
        }
        val list = ArrayList<TaskActionIdentity>()
        ArrayList(items.map {
            val tasks = it.actions
            tasks
        }).forEach(Consumer {
            list.addAll(it)
        })
        actionDomainUseCaseFactory.deleteAllActionsUseCase
                .run {
                    RequestAdapter<List<TaskActionIdentity>>(list).execute()
                }
    }
}