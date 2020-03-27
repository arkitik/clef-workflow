package io.quee.clef.workflow.api.contract.action.dto

import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionParamRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionParamRequestDto(
        override val parameterKey: String,
        override val parameterValue: String
) : TaskActionParamRequest