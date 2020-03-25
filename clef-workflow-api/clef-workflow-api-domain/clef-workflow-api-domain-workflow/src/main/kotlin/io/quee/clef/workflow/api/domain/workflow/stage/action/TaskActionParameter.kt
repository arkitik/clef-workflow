package io.quee.clef.workflow.api.domain.workflow.stage.action

import io.quee.api.develop.shared.model.EmbeddedData

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface TaskActionParameter : EmbeddedData {
    val parameterKey: String
    val parameterValue: String
}