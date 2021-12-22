package io.arkitik.clef.workflow.api.entity.workflow.embedded

import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionParameter
import javax.persistence.Column
import javax.persistence.Embeddable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Embeddable
data class TaskActionParameterImpl(
    @Column(nullable = false, updatable = false) override var parameterKey: String,
    @Column(nullable = false, updatable = false) override var parameterValue: String,
) : TaskActionParameter