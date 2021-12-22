package io.arkitik.clef.workflow.api.domain.workflow.stage.action

import io.arkitik.radix.develop.identity.EmbeddedData

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskActionParameter : EmbeddedData {
    val parameterKey: String
    val parameterValue: String
}