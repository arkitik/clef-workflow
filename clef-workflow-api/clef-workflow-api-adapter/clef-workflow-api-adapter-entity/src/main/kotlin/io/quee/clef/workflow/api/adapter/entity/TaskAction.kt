package io.quee.clef.workflow.api.adapter.entity

import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.adapter.shared.entity.BaseIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
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
class TaskAction(
        @Column(nullable = false) override var actionKey: String,
        @Column(nullable = false) override var actionName: String,
        @Column(nullable = false) override var actionDescription: String,
        @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST]) override var destinationTask: StageTask,
        @Id override var uuid: String = UUID.randomUUID().toString(),
        @Column(nullable = false) @Enumerated(EnumType.STRING) override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
        @Column(nullable = false) override var creationDate: LocalDateTime = LocalDateTime.now()
) : BaseIdentity(uuid, creationDate, identityStatus), TaskActionIdentity