package io.quee.clef.workflow.api.usecase.factory.workflow.request.stage

import io.quee.api.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface WorkflowStageRequest<T : UseCaseRequest> : UseCaseRequest {
    val request: T
    val stageKey: String
}