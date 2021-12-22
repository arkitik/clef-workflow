package io.arkitik.clef.workflow.api.usecase.domain.stage.main

import io.arkitik.radix.develop.usecase.validation.command.ValidationCommandUseCase
import io.arkitik.radix.develop.usecase.adapter.RequestAdapter
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageTaskDomainUseCaseFactory
import java.util.function.Consumer

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class DeleteAllStagesUseCase(
    private val stageStore: StageStore,
    private val taskDomainUseCaseFactory: StageTaskDomainUseCaseFactory,
) : ValidationCommandUseCase<RequestAdapter<List<StageIdentity>>>() {
    override fun RequestAdapter<List<StageIdentity>>.doExecute() {
        val items = ArrayList(request.map {
            stageStore.run {
                it.identityUpdater()
                    .delete()
                    .update()
            }
        })
        stageStore.run {
            items.save()
        }
        val list = ArrayList<StageTaskIdentity>()
        ArrayList(items.map {
            val tasks = ArrayList(it.tasks)
            if (it.initialTask != null)
                tasks.add(it.initialTask!!)
            tasks
        }).forEach(Consumer {
            list.addAll(it)
        })
        taskDomainUseCaseFactory.deleteAllTasksUseCase
            .run {
                RequestAdapter<List<StageTaskIdentity>>(list).execute()
            }
    }
}