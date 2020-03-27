package io.quee.clef.workflow.api.usecase.factory.workflow.response.action

import io.quee.api.develop.usecase.model.UseCaseResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class TaskActionDetails(
        val actionUuid: String,
        val actionKey: String,
        val actionName: String,
        val actionDescription: String,
        val destinationTask: ViewIdentify,
        val parameters: List<TaskActionParamDetails>
) : UseCaseResponse