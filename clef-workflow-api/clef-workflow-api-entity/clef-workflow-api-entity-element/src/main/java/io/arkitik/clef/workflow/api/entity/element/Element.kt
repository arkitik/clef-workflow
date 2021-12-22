package io.arkitik.clef.workflow.api.entity.element

import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.entity.workflow.StageTask
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.entity.workflow.WorkflowStage
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Entity
data class Element(
    @Column(nullable = false) override var elementKey: String,
    @ManyToOne(optional = false) override var workflow: Workflow,
    @ManyToOne(optional = false) override var currentStage: WorkflowStage,
    @ManyToOne(optional = false) override var currentTask: StageTask,
    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST]) override val flows: MutableList<ElementFlow> = ArrayList(),
    @Id override var uuid: String = UUID.randomUUID().toString(),
    @Column(nullable = false) override var creationDate: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
) : ElementIdentity