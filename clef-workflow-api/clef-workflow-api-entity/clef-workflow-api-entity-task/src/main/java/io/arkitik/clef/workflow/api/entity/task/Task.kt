package io.arkitik.clef.workflow.api.entity.task

import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Entity
data class Task(
    @Column(nullable = false, updatable = false)
    override var taskKey: String,
    @Column(nullable = false)
    override var taskName: String,
    @ManyToOne(optional = false)
    override val stage: Stage,
    @Id
    override val uuid: String = UUID.randomUUID().toString().replace("-", ""),
    @Column(nullable = false)
    override val creationDate: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
) : TaskIdentity
