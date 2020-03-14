package io.quee.clef.workflow.api.store.workflow.model

import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
class FakeWorkflowIdentity(
        override var workflowKey: String,
        override var workflowName: String,
        override var workflowDescription: String = "Some description",
        override var initialStage: StageIdentity? = null,
        override var stages: MutableList<StageIdentity> = ArrayList(),
        override var uuid: String = UUID.randomUUID().toString(),
        override var creationDate: LocalDateTime = LocalDateTime.now(),
        override var identityStatus: IdentityStatus = IdentityStatus.ENABLED
) : WorkflowIdentity