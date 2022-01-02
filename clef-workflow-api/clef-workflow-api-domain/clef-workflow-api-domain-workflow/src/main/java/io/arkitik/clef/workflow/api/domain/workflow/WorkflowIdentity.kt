package io.arkitik.clef.workflow.api.domain.workflow

import io.arkitik.clef.workflow.api.domain.shared.StatusAwareIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface WorkflowIdentity : StatusAwareIdentity<String> {
    val workflowKey: String
    val workflowName: String
    val workflowDescription: String
}
