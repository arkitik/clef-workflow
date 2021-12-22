package io.arkitik.clef.workflow.api.operation.workflow

import io.arkitik.radix.develop.operation.ext.operationBuilder
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.radix.develop.usecase.process
import io.arkitik.clef.workflow.api.sdk.shared.CodeMessageDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyUuidDto
import io.arkitik.clef.workflow.api.sdk.shared.SdkResponse
import io.arkitik.clef.workflow.api.sdk.workflow.WorkflowSdk
import io.arkitik.clef.workflow.api.sdk.workflow.dto.*
import io.arkitik.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.TaskActionStructure
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.TaskStructure

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 11:45 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
class WorkflowSdkImpl(
    private val workflowUseCaseFactory: WorkflowUseCaseFactory,
) : WorkflowSdk {
    override val createWorkflow = operationBuilder<CreateWorkflowDto, SdkResponse<KeyUuidDto>> {
        mainOperation {
            val viewIdentify = workflowUseCaseFactory.functional {
                createWorkflowUseCase
            } process CreateWorkflowRequest(
                workflowKey = workflowKey,
                workflowName = workflowName,
                workflowDescription = workflowDescription
            )
            SdkResponse(KeyUuidDto(viewIdentify.uuid, viewIdentify.key))
        }
    }

    override val workflowDetails = operationBuilder<String, SdkResponse<WorkflowDetailsDto>> {
        mainOperation {
            val response = workflowUseCaseFactory.functional {
                workflowDetailsUseCase
            } process WorkflowRequest(this)
            SdkResponse(
                WorkflowDetailsDto(
                    workflowUuid = response.workflowUuid,
                    workflowKey = response.workflowKey,
                    workflowName = response.workflowName,
                    workflowDescription = response.workflowDescription,
                    initialStage = response.initialStage?.let {
                        KeyUuidDto(it.uuid, it.key)
                    },
                    stages = response.stages.map {
                        KeyUuidDto(it.uuid, it.key)
                    }
                ))
        }
    }

    override val workflowsStructure = operationBuilder<Unit, SdkResponse<FullWorkflowStructureDto>> {
        mainOperation {
            val response = workflowUseCaseFactory.functional {
                fullWorkflowStructureUseCase
            } process UseCaseRequest.NOP
            val workflowStructures = response.workflows.map {
                WorkflowStructureDto(
                    workflowUuid = it.workflowUuid,
                    workflowKey = it.workflowKey,
                    workflowName = it.workflowName,
                    status = it.status.name,
                    workflowDescription = it.workflowDescription,
                    initialStage = it.initialStage?.let { stage ->
                        stageStructure(stage)
                    },
                    stages = it.stages.map { stage ->
                        stageStructure(stage)

                    }
                )
            }
            SdkResponse(FullWorkflowStructureDto(workflowStructures))
        }
    }

    private fun stageStructure(stage: io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.StageStructure) =
        StageStructureDto(
            stage.stageUuid,
            stage.stageKey,
            stage.stageName,
            stage.status.name,
            stage.initialTask?.let { task ->
                taskStructureDto(task)
            },
            tasks = stage.tasks.map { task ->
                taskStructureDto(task)
            }
        )

    private fun taskStructureDto(task: TaskStructure) =
        TaskStructureDto(
            taskUuid = task.taskUuid,
            taskKey = task.taskKey,
            taskName = task.taskName,
            status = task.status.name,
            actions = task.actions.map { action ->
                taskActionStructureDto(action)
            }
        )

    private fun taskActionStructureDto(action: TaskActionStructure) =
        TaskActionStructureDto(
            action.actionUuid,
            action.actionKey,
            action.actionName,
            action.status.name,
            action.actionDescription,
            action.destinationTask.let { view ->
                KeyUuidDto(view.uuid, view.key)
            }
        )


    override val enableWorkflow = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = workflowUseCaseFactory.functional {
                enableWorkflowUseCase
            } process WorkflowRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }

    override val disableWorkflow = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = workflowUseCaseFactory.functional {
                disableWorkflowUseCase
            } process WorkflowRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }
    override val deleteWorkflow = operationBuilder<String, SdkResponse<CodeMessageDto>> {
        mainOperation {
            val response = workflowUseCaseFactory.functional {
                deleteWorkflowUseCase
            } process WorkflowRequest(this)
            SdkResponse(CodeMessageDto(response.code, response.message))
        }
    }
}