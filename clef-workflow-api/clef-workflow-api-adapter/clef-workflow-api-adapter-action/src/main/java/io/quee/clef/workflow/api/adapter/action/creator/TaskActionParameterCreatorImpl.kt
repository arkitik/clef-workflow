package io.quee.clef.workflow.api.adapter.action.creator

import io.quee.clef.workflow.api.entity.workflow.embedded.TaskActionParameterImpl
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionParameter
import io.quee.clef.workflow.api.store.action.creator.TaskActionParameterCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionParameterCreatorImpl : TaskActionParameterCreator {
    private lateinit var parameterKey: String
    private lateinit var parameterValue: String
    override fun String.parameterKey(): TaskActionParameterCreator {
        parameterKey = this
        return this@TaskActionParameterCreatorImpl
    }

    override fun String.parameterValue(): TaskActionParameterCreator {
        parameterValue = this
        return this@TaskActionParameterCreatorImpl
    }

    override fun create(): TaskActionParameter {
        return TaskActionParameterImpl(parameterKey, parameterValue)
    }
}