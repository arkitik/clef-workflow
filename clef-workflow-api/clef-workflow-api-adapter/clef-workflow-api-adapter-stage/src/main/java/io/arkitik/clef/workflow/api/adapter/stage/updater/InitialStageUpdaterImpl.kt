package io.arkitik.clef.workflow.api.adapter.stage.updater

import io.arkitik.clef.workflow.api.entity.stage.InitialStage
import io.arkitik.clef.workflow.api.store.stage.updater.InitialStageUpdater

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:43 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class InitialStageUpdaterImpl(
    private val initialStage: InitialStage,
) : InitialStageUpdater {
    override fun update() = initialStage
}
