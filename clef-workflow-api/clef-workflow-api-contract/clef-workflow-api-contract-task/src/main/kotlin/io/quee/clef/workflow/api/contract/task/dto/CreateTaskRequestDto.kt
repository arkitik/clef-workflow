package io.quee.clef.workflow.api.contract.task.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.quee.clef.workflow.api.usecase.factory.workflow.request.task.CreateTaskRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class CreateTaskRequestDto(
        @JsonProperty("taskKey") override val taskKey: String,
        @JsonProperty("taskName") override val taskName: String,
        @JsonProperty("initialTask") override val initialTask: Boolean,
        @JsonProperty("stage") override val stage: DomainUuidAndKeyDto
) : CreateTaskRequest