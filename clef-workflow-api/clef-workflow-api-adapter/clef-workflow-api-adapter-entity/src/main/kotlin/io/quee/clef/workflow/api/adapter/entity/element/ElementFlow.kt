package io.quee.clef.workflow.api.adapter.entity.element

import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.adapter.entity.workflow.StageTask
import io.quee.clef.workflow.api.adapter.entity.workflow.TaskAction
import io.quee.clef.workflow.api.adapter.shared.entity.BaseIdentity
import io.quee.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Entity
class ElementFlow(
        @ManyToOne(optional = false) override var fromTask: StageTask,
        @ManyToOne(optional = false) override var toTask: StageTask,
        @ManyToOne(optional = false) override var action: TaskAction,
        @Id override var uuid: String = UUID.randomUUID().toString(),
        @Column(nullable = false) @Enumerated(EnumType.STRING) override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
        @Column(nullable = false) override var creationDate: LocalDateTime = LocalDateTime.now()
) : BaseIdentity(uuid, creationDate, identityStatus), ElementFlowIdentity