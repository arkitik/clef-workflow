package io.quee.clef.workflow.api.store.action.creator

import io.quee.api.develop.shared.func.Creator
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionParameter

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface TaskActionParameterCreator : Creator<TaskActionParameter> {
    fun String.parameterKey(): TaskActionParameterCreator
    fun String.parameterValue(): TaskActionParameterCreator
}