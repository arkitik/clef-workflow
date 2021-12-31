package io.arkitik.clef.workflow.api.entity.workflow

import io.arkitik.clef.workflow.api.entity.workflow.embedded.TaskActionParameterImpl
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
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
class TaskAction(
    @Column(nullable = false)
    override var actionKey: String,
    @Column(nullable = false)
    override var actionName: String,
    @Column(nullable = false)
    override var actionDescription: String,
    @ManyToOne
    override var destinationTask: StageTask,
    @ElementCollection @CollectionTable(name = "action_parameters")
    override val parameters: MutableList<TaskActionParameterImpl> = ArrayList(),
    @Id
    override var uuid: String = UUID.randomUUID().toString().replace("-",""),
    @Column(nullable = false)
    override var creationDate: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
) : TaskActionIdentity
