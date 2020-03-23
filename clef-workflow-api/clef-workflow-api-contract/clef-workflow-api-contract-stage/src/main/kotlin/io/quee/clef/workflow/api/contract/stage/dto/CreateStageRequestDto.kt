package io.quee.clef.workflow.api.contract.stage.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class CreateStageRequestDto(
        @JsonProperty("stageKey") override val stageKey: String,
        @JsonProperty("stageName") override val stageName: String,
        @JsonProperty("initialStage") override val initialStage: Boolean,
        @JsonProperty("workflow") override val workflow: DomainUuidAndKeyDto
) : CreateStageRequest