package io.arkitik.clef.workflow.api.controller.stage.api

import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.clef.workflow.api.controller.stage.contract.StageApiContract
import io.arkitik.clef.workflow.api.sdk.stage.dto.CreateStageDto
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RestController
class StageApiController(
    clefWorkflowEngine: ClefWorkflowEngine,
) : StageApiContract {
    private val stageSdk = clefWorkflowEngine.stageSdk
    override fun create(
        request: CreateStageDto,
    ) = stageSdk.createStage.runOperation(request)

    override fun details(
        key: String,
    ) = stageSdk.stageDetails.runOperation(key)

    override fun enable(
        key: String,
    ) = stageSdk.enableStage.runOperation(key)

    override fun disable(
        key: String,
    ) = stageSdk.disableStage.runOperation(key)

    override fun delete(
        key: String,
    ) = stageSdk.deleteStage.runOperation(key)
}