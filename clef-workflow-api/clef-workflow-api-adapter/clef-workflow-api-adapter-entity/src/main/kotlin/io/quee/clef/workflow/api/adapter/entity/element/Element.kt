package io.quee.clef.workflow.api.adapter.entity.element

import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.adapter.entity.workflow.StageTask
import io.quee.clef.workflow.api.adapter.entity.workflow.Workflow
import io.quee.clef.workflow.api.adapter.entity.workflow.WorkflowStage
import io.quee.clef.workflow.api.adapter.shared.entity.BaseIdentity
import io.quee.clef.workflow.api.domain.element.ElementIdentity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Entity
class Element(
        @Column(nullable = false) override var elementKey: String,
        @ManyToOne(optional = false) override var workflow: Workflow,
        @ManyToOne(optional = false) override var currentStage: WorkflowStage,
        @ManyToOne(optional = false) override var currentTask: StageTask,
        @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST]) override val flows: MutableList<ElementFlow> = ArrayList(),
        @Id override var uuid: String = UUID.randomUUID().toString(),
        @Column(nullable = false) @Enumerated(EnumType.STRING) override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
        @Column(nullable = false) override var creationDate: LocalDateTime = LocalDateTime.now()
) : BaseIdentity(uuid, creationDate, identityStatus), ElementIdentity