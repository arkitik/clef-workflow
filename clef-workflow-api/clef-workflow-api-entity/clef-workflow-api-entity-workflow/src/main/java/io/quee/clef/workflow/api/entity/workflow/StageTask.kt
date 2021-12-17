package io.quee.clef.workflow.api.entity.workflow

import io.quee.clef.workflow.api.domain.shared.embedded.IdentityStatus
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Entity
data class StageTask(
    @Column(nullable = false, updatable = false)
    override var taskKey: String,
    @Column(nullable = false)
    override var taskName: String,
    @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    override val actions: MutableList<TaskAction> = ArrayList(),
    @Id
    override val uuid: String = UUID.randomUUID().toString(),
    @Column(nullable = false)
    override val creationDate: LocalDateTime = LocalDateTime.now(),
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
) : StageTaskIdentity