package io.quee.clef.workflow.api.controller.stage.dto

import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class StageRequestDto(override val stageKey: String, override val stageUuid: String) : StageRequest