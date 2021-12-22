package io.arkitik.clef.workflow.api.usecase.domain.task.main

import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.store.task.StageTaskStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskActionDomainUseCaseFactory
import java.util.function.Consumer

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DeleteAllTasksUseCase(
    private val stageTaskStore: StageTaskStore,
    private val actionDomainUseCaseFactory: TaskActionDomainUseCaseFactory,
) : ValidationCommandUseCase<RequestAdapter<List<StageTaskIdentity>>>() {
    override fun RequestAdapter<List<StageTaskIdentity>>.doExecute() {
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