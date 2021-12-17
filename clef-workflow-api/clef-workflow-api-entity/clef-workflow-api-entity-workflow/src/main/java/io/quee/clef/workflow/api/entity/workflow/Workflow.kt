package io.quee.clef.workflow.api.entity.workflow

import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Entity
@Table
data class Workflow(
    @Column(nullable = false)
    override var workflowKey: String,
    @Column(nullable = false)
    override var workflowName: String,
    @Column(nullable = false)
    override var workflowDescription: String,
    @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    override var initialStage: WorkflowStage? = null,
    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    override var stages: MutableList<WorkflowStage> = ArrayList(),
    @Id
    override var uuid: String = UUID.randomUUID().toString(),
    @Column(nullable = false)
    override var creationDate: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
) : WorkflowIdentity