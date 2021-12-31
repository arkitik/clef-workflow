package io.arkitik.clef.workflow.api.entity.element

import io.arkitik.clef.workflow.api.domain.element.flow.ElementFlowIdentity
import io.arkitik.clef.workflow.api.entity.workflow.StageTask
import io.arkitik.clef.workflow.api.entity.workflow.TaskAction
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.entity.workflow.WorkflowStage
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
    @ManyToOne(optional = false) override val fromTask: StageTask,
    @ManyToOne(optional = false) override val toTask: StageTask,
    @ManyToOne(optional = false) override val action: TaskAction,
    @ManyToOne(optional = false) override val fromWorkflow: Workflow,
    @ManyToOne(optional = false) override val toWorkflow: Workflow,
    @ManyToOne(optional = false) override val fromStage: WorkflowStage,
    @ManyToOne(optional = false) override val toStage: WorkflowStage,
    @Id override var uuid: String = UUID.randomUUID().toString().replace("-", ""),
    @Column(nullable = false) override var creationDate: LocalDateTime = LocalDateTime.now(),
) : ElementFlowIdentity
