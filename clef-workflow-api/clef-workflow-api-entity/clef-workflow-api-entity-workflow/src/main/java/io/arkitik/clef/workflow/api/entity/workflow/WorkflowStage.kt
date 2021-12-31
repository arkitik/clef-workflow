package io.arkitik.clef.workflow.api.entity.workflow

import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Entity
@Table
data class WorkflowStage(
    @Column(nullable = false)
    override var stageKey: String,
    @Column(nullable = false)
    override var stageName: String,
    @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    override var initialTask: StageTask? = null,
    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    override var tasks: MutableList<StageTask> = ArrayList(),
    @Id
    override var uuid: String = UUID.randomUUID().toString().replace("-",""),
    @Column(nullable = false)
    override var creationDate: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
) : StageIdentity
