package io.arkitik.clef.workflow.api.adapter.task.updater

import io.arkitik.clef.workflow.api.entity.task.InitialTask
import io.arkitik.clef.workflow.api.store.task.updater.InitialTaskUpdater

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:56 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class InitialTaskUpdaterImpl(
    private val initialTask: InitialTask,
) : InitialTaskUpdater {
    override fun update() = initialTask
}
