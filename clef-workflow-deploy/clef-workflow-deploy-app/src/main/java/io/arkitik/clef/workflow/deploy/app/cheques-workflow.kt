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
 * Created At 31 10:28 PM, **Fri, December 2021**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
@Service
class ChequesWorkflowInitData(
    private val transactionManager: PlatformTransactionManager,
    private val clefWorkflowEngine: ClefWorkflowEngine,
) : CommandLineRunner {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(JobWorkflowInitData::class.java)!!
    }

    override fun run(vararg args: String?) {
        val transactionTemplate = TransactionTemplate(transactionManager)
        transactionTemplate.execute { transactionStatus ->
            with(clefWorkflowEngine) {
                LOGGER.debug("Start initializing Cheques Workflow")
                try {
                    persistWorkflow {
                        workflow {
                            key("cheques-workflow")
                            name("Cheques Workflow")
                            description("Cheques Workflow")
                            initialStage {
                                stageKey("stage-cheque-written")
                                stageName("Cheque Written")
                                stageInitialTask {
                                    taskKey("task-cheque-written")
                                    taskName("Cheque Written")
                                    taskAction {
                                        actionKey("action-fully-sign-written-cheque")
                                        actionName("Fully Sign Written Cheque")
                                        actionDescription("Fully Sign Written Cheque")
                                        actionDestinationTask("task-cheque-fully-signed")
                                    }
                                    taskAction {
                                        actionKey("action-partially-sign-written-cheque")
                                        actionName("Partially Sign Written Cheque")
                                        actionDescription("Partially Sign Written Cheque")
                                        actionDestinationTask("task-cheque-partially-signed")
                                    }
                                    taskAction {
                                        actionKey("action-reject-written-cheque")
                                        actionName("Reject Written Cheque")
                                        actionDescription("Reject Written Cheque")
                                        actionDestinationTask("task-cheque-rejected")
                                    }
                                }
                            }
                            stage {
                                stageKey("stage-cheque-partially-signed")
                                stageName("Cheque Partially Signed")
                                stageInitialTask {
                                    taskKey("task-cheque-partially-signed")
                                    taskName("Cheque Partially Signed")
                                    taskAction {
                                        actionKey("action-cheque-fully-sign-partially-signed")
                                        actionName("Fully Sign Partially Signed Cheque")
                                        actionDescription("Fully Sign Partially Signed Cheque")
                                        actionDestinationTask("task-cheque-fully-signed")
                                    }
                                    taskAction {
                                        actionKey("action-cheque-partially-sign-partially-signed")
                                        actionName("Partially Sign Written Cheque")
                                        actionDescription("Partially Sign Cheque")
                                        actionDestinationTask("task-cheque-partially-signed")
                                    }
                                    taskAction {
                                        actionKey("action-reject-partially-signed-cheque")
                                        actionName("Reject Cheque")
                                        actionDescription("Reject Cheque")
                                        actionDestinationTask("task-cheque-rejected")
                                    }
                                }
                            }
                            stage {
                                stageKey("stage-cheque-rejected")
                                stageName("Cheque Rejected")
                                stageTask {
                                    taskKey("task-cheque-rejected")
                                    taskName("Cheque Rejected")
                                }
                            }
                            stage {
                                stageKey("stage-cheque-cancelled")
                                stageName("Cheque Cancelled")
                                stageTask {
                                    taskKey("task-cheque-cancelled")
                                    taskName("Cheque Cancelled")
                                }
                            }
                            stage {
                                stageKey("stage-cheque-paid")
                                stageName("Cheque Paid")
                                stageTask {
                                    taskKey("task-cheque-paid")
                                    taskName("Cheque Paid")
                                }
                            }
                            stage {
                                stageKey("stage-cheque-fully-signed")
                                stageName("Cheque Fully Signed")
                                stageInitialTask {
                                    taskKey("task-cheque-fully-signed")
                                    taskName("Cheque Fully Signed Cheque")

                                    taskAction {
                                        actionKey("action-deposit-signed-cheque")
                                        actionName("Deposit Signed Cheque")
                                        actionDescription("Deposit Signed Cheque")
                                        actionDestinationTask("task-cheque-deposit-requested")
                                    }

                                    taskAction {
                                        actionKey("action-cancel-signed-cheque")
                                        actionName("Cancel Signed Cheque")
                                        actionDescription("Cancel Signed Cheque")
                                        actionDestinationTask("task-cheque-cancelled")
                                    }
                                }
                            }
                            stage {
                                stageKey("stage-cheque-deposit-requested")
                                stageName("Cheque Deposit Requested")
                                stageInitialTask {
                                    taskKey("task-cheque-deposit-requested")
                                    taskName("Cheque Deposit Requested")
                                    taskAction {
                                        actionKey("action-approve-cheque-deposit-request")
                                        actionName("Approve Cheque Deposit Request")
                                        actionDescription("Approve Cheque Deposit Request")
                                        actionDestinationTask("task-cheque-deposit-request-approved")
                                    }
                                    taskAction {
                                        actionKey("action-reject-cheque-deposit-request")
                                        actionName("Reject Cheque Deposit Request")
                                        actionDescription("Reject Cheque Deposit Request")
                                        actionDestinationTask("task-cheque-deposit-request-rejected")
                                    }
                                }
                            }
                            stage {
                                stageKey("stage-cheque-deposit-request-approved")
                                stageName("Cheque Deposit Request Approved")
                                stageInitialTask {
                                    taskKey("task-cheque-deposit-request-approved")
                                    taskName("Cheque Deposit Request Approved")
                                    taskAction {
                                        actionKey("action-cheque-deposit-request-pay")
                                        actionName("Pay Cheque")
                                        actionDescription("Pay Cheque")
                                        actionDestinationTask("task-cheque-paid")
                                    }
                                    taskAction {
                                        actionKey("action-cheque-deposit-request-return")
                                        actionName("Return Cheque")
                                        actionDescription("Return Cheque")
                                        actionDestinationTask("task-cheque-deposit-request-returned")
                                    }
                                }
                            }
                            stage {
                                stageKey("stage-cheque-deposit-request-rejected")
                                stageName("Cheque Deposit Rejected")
                                stageInitialTask {
                                    taskKey("task-cheque-deposit-request-rejected")
                                    taskName("Cheque Deposit Rejected")

                                    taskAction {
                                        actionKey("action-deposit-rejected-depositing-cheque")
                                        actionName("Deposit Cheque")
                                        actionDescription("Deposit Rejected Depositing Cheque")
                                        actionDestinationTask("task-cheque-deposit-requested")
                                    }

                                    taskAction {
                                        actionKey("action-cancel-rejected-depositing-cheque")
                                        actionName("Cancel Signed Cheque")
                                        actionDescription("Cancel Signed Cheque")
                                        actionDestinationTask("task-cheque-cancelled")
                                    }
                                }
                            }
                            stage {
                                stageKey("stage-cheque-deposit-request-returned")
                                stageName("Cheque Deposit Returned")
                                stageInitialTask {
                                    taskKey("task-cheque-deposit-request-returned")
                                    taskName("Cheque Deposit Returned")

                                    taskAction {
                                        actionKey("action-deposit-returned-depositing-cheque")
                                        actionName("Deposit Cheque")
                                        actionDescription("Deposit Returned Cheque")
                                        actionDestinationTask("task-cheque-deposit-requested")
                                    }

                                    taskAction {
                                        actionKey("action-cancel-returned-depositing-cheque")
                                        actionName("Cancel Returned Cheque")
                                        actionDescription("Cancel Returned Cheque")
                                        actionDestinationTask("task-cheque-cancelled")
                                    }
                                }
                            }
                        }
                    }

                    LOGGER.debug("Initializing Cheques Workflow has been done")
                } catch (e: Exception) {
                    LOGGER.error("Initializing Cheques Workflow has been failed [Error: {}]", e.message, e)
                    transactionStatus.setRollbackOnly()
                }
            }

        }
    }
}
