package io.arkitik.clef.workflow.api.entity.stage

import io.arkitik.clef.workflow.api.domain.stage.InitialStageIdentity
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 4:52 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
@Entity
data class InitialStage(
    @OneToOne(optional = false)
    override val stage: Stage,
    @OneToOne(optional = false)
    override val workflow: Workflow,
    @Id
    override var uuid: String = UUID.randomUUID().toString().replace("-", ""),
    @Column(nullable = false)
    override var creationDate: LocalDateTime = LocalDateTime.now(),
) : InitialStageIdentity
