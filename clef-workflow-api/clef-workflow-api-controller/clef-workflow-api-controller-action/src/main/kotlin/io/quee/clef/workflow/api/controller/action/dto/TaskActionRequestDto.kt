package io.quee.clef.workflow.api.controller.action.dto

import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class TaskActionRequestDto(
        override val actionKey: String,
        override val actionUuid: String
) : TaskActionRequest