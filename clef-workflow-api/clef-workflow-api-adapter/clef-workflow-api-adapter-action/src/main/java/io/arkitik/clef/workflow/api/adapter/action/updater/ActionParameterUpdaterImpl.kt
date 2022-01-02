package io.arkitik.clef.workflow.api.adapter.action.updater

import io.arkitik.clef.workflow.api.entity.action.ActionParameter
import io.arkitik.clef.workflow.api.store.action.updater.ActionParameterUpdater

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:31 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class ActionParameterUpdaterImpl(
    private val actionParameter: ActionParameter,
) : ActionParameterUpdater {
    override fun update() = actionParameter
}
