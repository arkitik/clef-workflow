package io.quee.clef.workflow.api.adapter.entity

import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.clef.workflow.api.adapter.shared.entity.BaseIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Entity
@Table
class WorkflowStage(
        @Column(nullable = false) override var stageKey: String,
        @Column(nullable = false) override var stageName: String,
        @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST]) override var initialTask: StageTask? = null,
        @OneToMany(cascade = [CascadeType.MERGE, CascadeType.PERSIST]) override var tasks: MutableList<StageTask> = ArrayList(),
        @Id override var uuid: String = UUID.randomUUID().toString(),
        @Column(nullable = false) @Enumerated(EnumType.STRING) override var identityStatus: IdentityStatus = IdentityStatus.ENABLED,
        @Column(nullable = false) override var creationDate: LocalDateTime = LocalDateTime.now()
) : BaseIdentity(uuid, creationDate, identityStatus), StageIdentity