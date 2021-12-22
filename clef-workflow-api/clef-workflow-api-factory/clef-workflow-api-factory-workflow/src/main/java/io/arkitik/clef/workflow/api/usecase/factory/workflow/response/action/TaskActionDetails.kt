package io.arkitik.clef.workflow.api.usecase.factory.workflow.response.action

import io.arkitik.radix.develop.usecase.model.UseCaseResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class TaskActionDetails(
    val actionUuid: String,
    val actionKey: String,
    val actionName: String,
    val actionDescription: String,
    val destinationTask: ViewIdentify,
    val parameters: List<TaskActionParamDetails>,
) : UseCaseResponse