package io.arkitik.clef.workflow.api.entity.action

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.entity.task.Task
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
data class Action(
    @Column(nullable = false, updatable = false)
    override val actionKey: String,
    @Column(nullable = false)
    override val actionName: String,
    @Column(nullable = false)
    override val actionDescription: String,
    @ManyToOne(optional = false)
    override val sourceTask: Task,
    @ManyToOne(optional = false)
    override val destinationTask: Task,
    @Id
    override val uuid: String = UUID.randomUUID().toString().replace("-", ""),
    @Column(nullable = false, updatable = false)
    override val creationDate: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
) : ActionIdentity
