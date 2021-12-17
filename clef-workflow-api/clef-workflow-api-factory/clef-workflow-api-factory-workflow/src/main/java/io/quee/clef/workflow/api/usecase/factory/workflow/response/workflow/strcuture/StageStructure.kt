package io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture

import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
data class StageStructure(
    val stageUuid: String,
    val stageKey: String,
    val stageName: String,
    val status: IdentityStatus,
    val initialTask: TaskStructure?,
    val tasks: List<TaskStructure>,
)