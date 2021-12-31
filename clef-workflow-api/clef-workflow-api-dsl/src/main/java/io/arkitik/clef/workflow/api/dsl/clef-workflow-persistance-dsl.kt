package io.arkitik.clef.workflow.api.dsl

import io.arkitik.clef.workflow.api.sdk.action.dto.CreateTaskActionDto
import io.arkitik.clef.workflow.api.sdk.action.dto.TaskActionParamDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyDto
import io.arkitik.clef.workflow.api.sdk.stage.dto.CreateStageDto
import io.arkitik.clef.workflow.api.sdk.task.dto.CreateStageTaskDto
import io.arkitik.clef.workflow.api.sdk.workflow.dto.CreateWorkflowDto
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 24 4:10 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */

fun ClefWorkflowEngine.persistWorkflow(
    builder: ClefWorkflowsBuilder.() -> Unit,
) {
    val workflows = ClefWorkflowsBuilder().apply(builder).build()
    val workflowsDtos = workflows.map { workflow ->
        CreateWorkflowDto(
            workflowKey = workflow.key,
            workflowName = workflow.name,
            workflowDescription = workflow.description
        )
    }
    val workflowStagesDtos = workflows.map { workflow ->
        workflow.workflowStages()
    }.flatten()

    val stageTasks = workflows.map { workflow ->
        workflow.workflowStageTasks()
    }.flatten()

    val taskActions = workflows.map { workflow ->
        workflow.taskActions()
    }.flatten()


    workflowSdk.createWorkflow.run {
        workflowsDtos.forEach { it.operate() }
    }
    stageSdk.createStage.run {
        workflowStagesDtos.forEach { it.operate() }
    }
    stageTaskSdk.createStageTask.run {
        stageTasks.forEach { it.operate() }
    }
    actionSdk.createAction.run {
        taskActions.forEach { it.operate() }
    }
}

fun WorkflowData.workflowStages(): List<CreateStageDto> {
    val stagesDtos = mutableListOf<CreateStageDto>()

    stages.map { stage ->
        CreateStageDto(
            stageKey = stage.key,
            stageName = stage.name,
            initialStage = false,
            workflow = KeyDto(key),
        )
    }.let {
        stagesDtos.addAll(it)
    }
    initialStage?.also { stage ->
        val stageDto = CreateStageDto(
            stageKey = stage.key,
            stageName = stage.name,
            initialStage = true,
            workflow = KeyDto(key),
        )
        stagesDtos.add(stageDto)
    }
    return stagesDtos
}

fun WorkflowData.workflowStageTasks(): List<CreateStageTaskDto> {
    val stageTasksDtos = mutableListOf<CreateStageTaskDto>()
    stages.forEach { stage ->
        stage.tasks.map { stageTask ->
            CreateStageTaskDto(
                taskKey = stageTask.key,
                taskName = stageTask.name,
                initialTask = false,
                stage = KeyDto(stage.key)
            )
        }.also { stageTasksDtos.addAll(it) }
        stage.initialTask?.let { stageTask ->
            val createStageTaskDto = CreateStageTaskDto(
                taskKey = stageTask.key,
                taskName = stageTask.name,
                initialTask = true,
                stage = KeyDto(stage.key)
            )
            stageTasksDtos.add(createStageTaskDto)
        }
    }
    initialStage?.let { stage ->
        stage.tasks.map { stageTask ->
            CreateStageTaskDto(
                taskKey = stageTask.key,
                taskName = stageTask.name,
                initialTask = false,
                stage = KeyDto(stage.key)
            )
        }.also { stageTasksDtos.addAll(it) }
        stage.initialTask?.let { stageTask ->
            val createStageTaskDto = CreateStageTaskDto(
                taskKey = stageTask.key,
                taskName = stageTask.name,
                initialTask = true,
                stage = KeyDto(stage.key)
            )
            stageTasksDtos.add(createStageTaskDto)
        }
    }
    return stageTasksDtos
}

fun WorkflowData.taskActions(): List<CreateTaskActionDto> {
    val taskActionsDtos = mutableListOf<CreateTaskActionDto>()
    stages.forEach { stage ->
        stage.tasks.forEach { stageTask ->
            val list = stageTask.actions.map { taskAction ->
                CreateTaskActionDto(
                    actionKey = taskAction.key,
                    actionName = taskAction.name,
                    actionDescription = taskAction.description,
                    sourceTask = KeyDto(stageTask.key),
                    destinationTask = KeyDto(taskAction.destinationTask),
                    parameters = taskAction.parameters.map {
                        TaskActionParamDto(it.first, it.second)
                    }
                )
            }
            taskActionsDtos.addAll(list)
        }
        stage.initialTask?.let { stageTask ->
            val list = stageTask.actions.map { taskAction ->
                CreateTaskActionDto(
                    actionKey = taskAction.key,
                    actionName = taskAction.name,
                    actionDescription = taskAction.description,
                    sourceTask = KeyDto(stageTask.key),
                    destinationTask = KeyDto(taskAction.destinationTask),
                    parameters = taskAction.parameters.map {
                        TaskActionParamDto(it.first, it.second)
                    }
                )
            }
            taskActionsDtos.addAll(list)
        }
    }
    initialStage?.let { stage ->
        stage.tasks.forEach { stageTask ->
            val list = stageTask.actions.map { taskAction ->
                CreateTaskActionDto(
                    actionKey = taskAction.key,
                    actionName = taskAction.name,
                    actionDescription = taskAction.description,
                    sourceTask = KeyDto(stageTask.key),
                    destinationTask = KeyDto(taskAction.destinationTask),
                    parameters = taskAction.parameters.map {
                        TaskActionParamDto(it.first, it.second)
                    }
                )
            }
            taskActionsDtos.addAll(list)
        }
        stage.initialTask?.let { stageTask ->
            val list = stageTask.actions.map { taskAction ->
                CreateTaskActionDto(
                    actionKey = taskAction.key,
                    actionName = taskAction.name,
                    actionDescription = taskAction.description,
                    sourceTask = KeyDto(stageTask.key),
                    destinationTask = KeyDto(taskAction.destinationTask),
                    parameters = taskAction.parameters.map {
                        TaskActionParamDto(it.first, it.second)
                    }
                )
            }
            taskActionsDtos.addAll(list)
        }
    }
    return taskActionsDtos
}