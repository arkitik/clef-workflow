package io.arkitik.clef.workflow.api.controller.task.api

import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.clef.workflow.api.controller.task.contract.StageTaskApiContract
import io.arkitik.clef.workflow.api.sdk.task.dto.CreateStageTaskDto
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RestController
class StageTaskApiController(
    clefWorkflowEngine: ClefWorkflowEngine,
) : StageTaskApiContract {
    private val stageTaskSdk = clefWorkflowEngine.stageTaskSdk

    override fun create(request: CreateStageTaskDto) =
        stageTaskSdk.createStageTask.runOperation(request)

    override fun details(
        key: String,
    ) = stageTaskSdk.stageTaskDetails.runOperation(key)

    override fun enable(
        key: String,
    ) = stageTaskSdk.enableStageTask.runOperation(key)

    override fun disable(
        key: String,
    ) = stageTaskSdk.disableStageTask.runOperation(key)

    override fun delete(
        key: String,
    ) = stageTaskSdk.deleteStageTask.runOperation(key)
}