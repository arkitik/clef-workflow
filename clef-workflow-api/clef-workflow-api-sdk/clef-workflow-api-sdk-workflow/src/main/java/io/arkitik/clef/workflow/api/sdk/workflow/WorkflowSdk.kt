package io.arkitik.clef.workflow.api.sdk.workflow

import io.arkitik.radix.develop.operation.Operation
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.sdk.workflow.dto.CreateWorkflowDto
import io.arkitik.clef.workflow.api.sdk.workflow.dto.FullWorkflowStructureDto
import io.arkitik.clef.workflow.api.sdk.workflow.dto.WorkflowDetailsDto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:06 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
interface WorkflowSdk {
    val createWorkflow: Operation<CreateWorkflowDto, SdkResponse<KeyUuidDto>>
    val workflowDetails: Operation<String, SdkResponse<WorkflowDetailsDto>>
    val workflowsStructure: Operation<Unit, SdkResponse<FullWorkflowStructureDto>>
    val enableWorkflow: Operation<String, SdkResponse<CodeMessageDto>>
    val disableWorkflow: Operation<String, SdkResponse<CodeMessageDto>>
    val deleteWorkflow: Operation<String, SdkResponse<CodeMessageDto>>

}