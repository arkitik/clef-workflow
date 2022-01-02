package io.arkitik.clef.workflow.api.entity.task

import io.arkitik.clef.workflow.api.domain.task.InitialTaskIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 4:55 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
@Entity
data class InitialTask(
    @OneToOne(optional = false)
    override val task: Task,
    @OneToOne(optional = false)
    override val stage: Stage,
    @Id
    override val uuid: String = UUID.randomUUID().toString().replace("-", ""),
    @Column(nullable = false, updatable = false)
    override val creationDate: LocalDateTime = LocalDateTime.now(),
) : InitialTaskIdentity
