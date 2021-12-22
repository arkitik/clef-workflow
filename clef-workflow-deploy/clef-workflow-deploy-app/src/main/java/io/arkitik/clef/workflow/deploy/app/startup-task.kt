package io.arkitik.clef.workflow.deploy.app

import io.arkitik.clef.workflow.api.sdk.action.dto.CreateTaskActionDto
import io.arkitik.clef.workflow.api.sdk.element.dto.CreateElementDto
import io.arkitik.clef.workflow.api.sdk.shared.KeyDto
import io.arkitik.clef.workflow.api.sdk.stage.dto.CreateStageDto
import io.arkitik.clef.workflow.api.sdk.task.dto.CreateStageTaskDto
import io.arkitik.clef.workflow.api.sdk.workflow.dto.CreateWorkflowDto
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 9:46 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
@Service
class JobWorkflowInitData(
    private val clefWorkflowEngine: ClefWorkflowEngine,
) : CommandLineRunner {
    companion object {
        val LOGGER = org.slf4j.LoggerFactory.getLogger(JobWorkflowInitData::class.java)!!
    }

    override fun run(vararg args: String?) {
        val workflowKey = "job-workflow"


        val pendingStage = "pending-job-execution"
        val runningStage = "running-job-execution"
        val cancelledStage = "cancelled-job-execution"
        val processedStage = "processed-job-execution"
        val failedStage = "failed-job-execution"
        val internalFailedStage = "internal-failed-job-execution"

        val pendingTask = "pending-task-execution-task"
        val runningTask = "running-task-execution-task"
        val cancelledTask = "cancelled-task-execution-task"
        val doneTask = "processed-task-execution-task"
        val failedTask = "failed-task-execution-task"
        val internalFailureTask = "internal-failure-task-execution-task"

        val triggerJobAction = "trigger-job"
        val cancelPendingAction = "cancel-waiting-job"
        val cancelFailedJobAction = "cancel-failed-job"
        val markJobAsDoneAction = "mark-job-as-done"
        val markJobAsFailedAction = "mark-job-as-failed"
        val reTriggerAction = "re-trigger"
        val internalFailureAction = "internal-failure"


        with(clefWorkflowEngine) {
            LOGGER.debug("Start initializing JOB execution workflow")
            try {
                workflowSdk.createWorkflow.apply {
                    CreateWorkflowDto(
                        workflowKey = workflowKey,
                        workflowName = "Job Execution workflow",
                        workflowDescription = "The full job execution procedure workflow"
                    ).operate()
                }
                stageSdk.createStage.apply {
                    CreateStageDto(
                        stageKey = pendingStage,
                        stageName = "Pending Stage",
                        initialStage = true,
                        workflow = KeyDto(workflowKey),
                    ).operate()
                    CreateStageDto(
                        stageKey = runningStage,
                        stageName = "Running Stage",
                        initialStage = false,
                        workflow = KeyDto(workflowKey),
                    ).operate()
                    CreateStageDto(
                        stageKey = processedStage,
                        stageName = "Processed Stage",
                        initialStage = false,
                        workflow = KeyDto(workflowKey),
                    ).operate()
                    CreateStageDto(
                        stageKey = failedStage,
                        stageName = "Failed Stage",
                        initialStage = false,
                        workflow = KeyDto(workflowKey),
                    ).operate()
                    CreateStageDto(
                        stageKey = cancelledStage,
                        stageName = "Cancelled Stage",
                        initialStage = false,
                        workflow = KeyDto(workflowKey),
                    ).operate()
                    CreateStageDto(
                        stageKey = internalFailedStage,
                        stageName = "Internal-Failure",
                        initialStage = false,
                        workflow = KeyDto(workflowKey),
                    ).operate()
                }
                stageTaskSdk.createStageTask.apply {
                    CreateStageTaskDto(
                        taskKey = pendingTask,
                        taskName = "Waiting",
                        initialTask = true,
                        stage = KeyDto(pendingStage)
                    ).operate()
                    CreateStageTaskDto(
                        taskKey = runningTask,
                        taskName = "In Processing",
                        initialTask = false,
                        stage = KeyDto(runningStage)
                    ).operate()

                    CreateStageTaskDto(
                        taskKey = doneTask,
                        taskName = "Done",
                        initialTask = false,
                        stage = KeyDto(processedStage)
                    ).operate()
                    CreateStageTaskDto(
                        taskKey = failedTask,
                        taskName = "Execution-Failed",
                        initialTask = false,
                        stage = KeyDto(failedStage)
                    ).operate()

                    CreateStageTaskDto(
                        taskKey = cancelledTask,
                        taskName = "Cancelled",
                        initialTask = false,
                        stage = KeyDto(cancelledStage)
                    ).operate()
                    CreateStageTaskDto(
                        taskKey = internalFailureTask,
                        taskName = "Internal-Failure",
                        initialTask = false,
                        stage = KeyDto(internalFailedStage)
                    ).operate()
                }
                actionSdk.createAction.apply {
                    CreateTaskActionDto(
                        actionKey = triggerJobAction,
                        actionName = "Run Job",
                        actionDescription = "Start JOB Execution",
                        sourceTask = KeyDto(pendingTask),
                        destinationTask = KeyDto(runningTask),
                        parameters = listOf()
                    ).operate()

                    CreateTaskActionDto(
                        actionKey = markJobAsDoneAction,
                        actionName = "Mark As Done",
                        actionDescription = "JOB Execution done with success",
                        sourceTask = KeyDto(runningTask),
                        destinationTask = KeyDto(doneTask),
                        parameters = listOf()
                    ).operate()
                    CreateTaskActionDto(
                        actionKey = markJobAsFailedAction,
                        actionName = "Mark As Failed",
                        actionDescription = "JOB Execution failed",
                        sourceTask = KeyDto(runningTask),
                        destinationTask = KeyDto(failedTask),
                        parameters = listOf()
                    ).operate()
                    CreateTaskActionDto(
                        actionKey = reTriggerAction,
                        actionName = "Re-Trigger",
                        actionDescription = "ReTrigger JOB Execution",
                        sourceTask = KeyDto(failedTask),
                        destinationTask = KeyDto(pendingTask),
                        parameters = listOf()
                    ).operate()


                    CreateTaskActionDto(
                        actionKey = cancelPendingAction,
                        actionName = "Cancel pending job",
                        actionDescription = "Cancel Pending JOB Execution",
                        sourceTask = KeyDto(pendingTask),
                        destinationTask = KeyDto(cancelledTask),
                        parameters = listOf()
                    ).operate()
                    CreateTaskActionDto(
                        actionKey = cancelFailedJobAction,
                        actionName = "Cancel failed job",
                        actionDescription = "Cancel Failed JOB Execution",
                        sourceTask = KeyDto(failedTask),
                        destinationTask = KeyDto(cancelledTask),
                        parameters = listOf()
                    ).operate()


                    CreateTaskActionDto(
                        actionKey = internalFailureAction,
                        actionName = "Internal Failure",
                        actionDescription = "Internal Failure While JOB Execution",
                        sourceTask = KeyDto(runningTask),
                        destinationTask = KeyDto(internalFailureTask),
                        parameters = listOf()
                    ).operate()
                }


                elementSdk.createElement.apply {
                    (0..100).forEach {
                        CreateElementDto(
                            elementKey = "element-$it",
                            workflow = KeyDto(workflowKey)
                        ).operate()
                    }
                }
                LOGGER.debug("Initializing JOB execution workflow has been done")
            } catch (e: Exception) {
                LOGGER.error("Initializing JOB execution workflow has been failed", e)
            }
        }
    }

}