package io.arkitik.clef.workflow.api.entity.element

import io.arkitik.clef.workflow.api.domain.element.ElementFlowIdentity
import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.task.Task
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Entity
data class ElementFlow(
    @ManyToOne(optional = false) override val element: Element,
    @ManyToOne(optional = false) override val action: Action,
    @ManyToOne(optional = false) override val fromTask: Task,
    @ManyToOne(optional = false) override val toTask: Task,
    @ManyToOne(optional = false) override val fromWorkflow: Workflow,
    @ManyToOne(optional = false) override val toWorkflow: Workflow,
    @ManyToOne(optional = false) override val fromStage: Stage,
    @ManyToOne(optional = false) override val toStage: Stage,
    @Id override var uuid: String = UUID.randomUUID().toString().replace("-", ""),
    @Column(nullable = false) override var creationDate: LocalDateTime = LocalDateTime.now(),
) : ElementFlowIdentity
