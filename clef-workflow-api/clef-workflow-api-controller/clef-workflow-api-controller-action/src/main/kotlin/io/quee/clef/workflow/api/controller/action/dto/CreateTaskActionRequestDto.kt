package io.quee.clef.workflow.api.controller.action.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.quee.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class CreateTaskActionRequestDto(
        @JsonProperty("actionKey") override val actionKey: String,
        @JsonProperty("actionName") override val actionName: String,
        @JsonProperty("actionDescription") override val actionDescription: String,
        @JsonProperty("sourceTask") override val sourceTask: DomainUuidAndKeyDto,
        @JsonProperty("destinationTask") override val destinationTask: DomainUuidAndKeyDto
) : CreateTaskActionRequest