package io.quee.clef.workflow.api.contract.action.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.quee.clef.workflow.api.usecase.factory.workflow.request.DomainUuidAndKey
import javax.validation.constraints.NotBlank

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class DomainUuidAndKeyDto(
        @JsonProperty("uuid") @get:NotBlank override val uuid: String,
        @JsonProperty("key") @get:NotBlank override val key: String
) : DomainUuidAndKey