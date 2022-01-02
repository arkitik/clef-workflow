package io.arkitik.clef.workflow.api.entity.action

import io.arkitik.clef.workflow.api.domain.action.ActionParameterIdentity
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Entity
data class ActionParameter(
    @Column(nullable = false, updatable = false)
    override var parameterKey: String,
    @Column(nullable = false, updatable = false)
    override var parameterValue: String,
    @ManyToOne(optional = false)
    override val action: Action,
    @Id
    override val uuid: String = UUID.randomUUID().toString().replace("-", ""),
    override val creationDate: LocalDateTime = LocalDateTime.now(),
) : ActionParameterIdentity
