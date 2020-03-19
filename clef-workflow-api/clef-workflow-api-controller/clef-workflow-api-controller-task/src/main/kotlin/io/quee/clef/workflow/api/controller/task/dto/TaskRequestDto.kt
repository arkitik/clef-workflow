package io.quee.clef.workflow.api.controller.task.dto

import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.TaskRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class TaskRequestDto(
        override val taskKey: String,
        override val taskUuid: String
) : TaskRequest