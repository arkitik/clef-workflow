package io.arkitik.clef.workflow.api.store.action.creator

import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionParameter

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskActionParameterCreator {
    fun String.parameterKey(): TaskActionParameterCreator
    fun String.parameterValue(): TaskActionParameterCreator
    fun create(): TaskActionParameter
}