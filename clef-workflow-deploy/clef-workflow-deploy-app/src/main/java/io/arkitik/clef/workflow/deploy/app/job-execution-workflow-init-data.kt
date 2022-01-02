package io.arkitik.clef.workflow.deploy.app

import io.arkitik.clef.workflow.api.dsl.persistWorkflow
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.support.TransactionTemplate

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17 9:46 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
@Service
class JobWorkflowInitData(
    private val transactionManager: PlatformTransactionManager,
    private val clefWorkflowEngine: ClefWorkflowEngine,
) : CommandLineRunner {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(JobWorkflowInitData::class.java)!!
    }

    override fun run(vararg args: String?) {
        val transactionTemplate = TransactionTemplate(transactionManager)
        transactionTemplate.execute { transactionStatus ->
            LOGGER.debug("Start initializing JOB execution workflow")
            try {
                clefWorkflowEngine.persistWorkflow {
                    workflow {
                        key("job-workflow")
                        name("Job Execution workflow")
                        description("The full job execution procedure workflow")
                        initialStage {
                            stageKey("pending-job-execution")
                            stageName("Pending Stage")
                            stageInitialTask {
                                taskKey("pending-task-execution-task")
                                taskName("Waiting")
                                taskAction {
                                    actionKey("trigger-job")
                                    actionName("Run Job")
                                    actionDescription("Start JOB Execution")
                                    actionDestinationTask("running-task-execution-task")
                                }
                                taskAction {
                                    actionKey("cancel-waiting-job")
                                    actionName("Cancel pending job")
                                    actionDescription("Cancel Pending JOB Execution")
                                    actionDestinationTask("cancelled-task-execution-task")
                                }
                            }
                        }
                        stage {
                            stageName("Running Stage")
                            stageKey("running-job-execution")
                            stageTask {
                                taskKey("running-task-execution-task")
                                taskName("In Processing")
                                taskAction {
                                    actionKey("mark-job-as-done")
                                    actionName("Mark As Done")
                                    actionDescription("JOB Execution done with success")
                                    actionDestinationTask("processed-task-execution-task")
                                }
                                taskAction {
                                    actionKey("mark-job-as-failed")
                                    actionName("Mark As Failed")
                                    actionDescription("JOB Execution failed")
                                    actionDestinationTask("failed-task-execution-task")
                                }
                                taskAction {
                                    actionKey("internal-failure")
                                    actionName("Internal Failure")
                                    actionDescription("Internal Failure While JOB Execution")
                                    actionDestinationTask("internal-failure-task-execution-task")
                                }
                            }
                        }
                        stage {
                            stageKey("processed-job-execution")
                            stageName("Processed Stage")
                            stageTask {
                                taskKey("processed-task-execution-task")
                                taskName("Done")
                            }
                        }
                        stage {
                            stageKey("failed-job-execution")
                            stageName("Failed Stage")
                            stageTask {
                                taskKey("failed-task-execution-task")
                                taskName("Execution-Failed")

                                taskAction {
                                    actionKey("re-trigger")
                                    actionName("Re-Trigger")
                                    actionDescription("ReTrigger JOB Execution")
                                    actionDestinationTask("pending-task-execution-task")
                                }
                                taskAction {
                                    actionKey("cancel-failed-job")
                                    actionName("Cancel failed job")
                                    actionDescription("Cancel Failed JOB Execution")
                                    actionDestinationTask("cancelled-task-execution-task")
                                }
                            }
                        }
                        stage {
                            stageKey("cancelled-job-execution")
                            stageName("Cancelled Stage")
                            stageTask {
                                taskKey("cancelled-task-execution-task")
                                taskName("Cancelled")
                            }
                        }
                        stage {
                            stageKey("internal-failed-job-execution")
                            stageName("Internal-Failure")
                            stageTask {
                                taskKey("internal-failure-task-execution-task")
                                taskName("Internal-Failure")
                            }
                        }
                    }
                }
                LOGGER.debug("Initializing JOB execution workflow has been done")
            } catch (e: Exception) {
                LOGGER.error("Initializing JOB execution workflow has been failed [Error: {}]", e.message)
                transactionStatus.setRollbackOnly()
            }
        }

    }

}
