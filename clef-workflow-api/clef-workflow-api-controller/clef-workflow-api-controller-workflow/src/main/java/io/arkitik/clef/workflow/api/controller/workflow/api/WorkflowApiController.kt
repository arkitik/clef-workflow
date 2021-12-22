package io.arkitik.clef.workflow.api.controller.workflow.api

import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.clef.workflow.api.controller.workflow.contract.WorkflowApiContract
import io.arkitik.clef.workflow.api.sdk.workflow.dto.CreateWorkflowDto
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RestController
class WorkflowApiController(
    private val clefWorkflowEngine: ClefWorkflowEngine,
) : WorkflowApiContract {
    override fun create(request: CreateWorkflowDto) =
        clefWorkflowEngine.workflowSdk.createWorkflow.runOperation(request)

    override fun details(key: String) =
        clefWorkflowEngine.workflowSdk.workflowDetails.runOperation(key)

    override fun structure() =
        clefWorkflowEngine.workflowSdk.workflowsStructure.runOperation(Unit)

    override fun enable(key: String) =
        clefWorkflowEngine.workflowSdk.enableWorkflow.runOperation(key)

    override fun disable(key: String) =
        clefWorkflowEngine.workflowSdk.disableWorkflow.runOperation(key)

    override fun delete(key: String) =
        clefWorkflowEngine.workflowSdk.deleteWorkflow.runOperation(key)
}