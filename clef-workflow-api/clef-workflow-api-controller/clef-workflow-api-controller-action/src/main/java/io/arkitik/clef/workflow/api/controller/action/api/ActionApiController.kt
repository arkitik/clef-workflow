package io.arkitik.clef.workflow.api.controller.action.api

import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.clef.workflow.api.controller.action.contract.ActionApiContract
import io.arkitik.clef.workflow.api.sdk.action.dto.CreateTaskActionDto
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RestController
class ActionApiController(
    clefWorkflowEngine: ClefWorkflowEngine,
) : ActionApiContract {
    private val actionSdk = clefWorkflowEngine.actionSdk

    override fun create(request: CreateTaskActionDto) =
        actionSdk.createAction.runOperation(request)

    override fun details(
        key: String,
    ) = actionSdk.actionDetails.runOperation(key)

    override fun enable(
        key: String,
    ) = actionSdk.enableAction.runOperation(key)

    override fun disable(
        key: String,
    ) = actionSdk.disableAction.runOperation(key)

    override fun delete(
        key: String,
    ) = actionSdk.deleteAction.runOperation(key)
}