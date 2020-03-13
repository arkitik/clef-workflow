package io.quee.clef.workflow.api.usecase.factory.workflow.request.stage

import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
interface StageRequest<T : UseCaseRequest> : WorkflowRequest<T> {
    val stageKey: String
    val stageUuid: String
}