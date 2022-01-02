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
class MultiChequesWorkflowInitData(
    private val transactionManager: PlatformTransactionManager,
    private val clefWorkflowEngine: ClefWorkflowEngine,
) : CommandLineRunner {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(MultiChequesWorkflowInitData::class.java)!!
    }

    override fun run(vararg args: String?) {
        val transactionTemplate = TransactionTemplate(transactionManager)
        transactionTemplate.execute { transactionStatus ->
            LOGGER.debug("Start initializing Multi Cheques Workflow")
            try {
                clefWorkflowEngine.persistWorkflow {
                    workflow {
                        key("multi-cheques-workflow-0")
                        name("Multi Cheques Workflow")
                        description("Multi Cheques Workflow")
                        initialStage {
                            stageKey("multi-stage-cheque-written")
                            stageName("Cheque Written")
                            stageInitialTask {
                                taskKey("multi-task-cheque-written")
                                taskName("Cheque Written")
                                taskAction {
                                    actionKey("multi-action-fully-sign-written-cheque")
                                    actionName("Fully Sign Written Cheque")
                                    actionDescription("Fully Sign Written Cheque")
                                    actionDestinationTask("multi-task-cheque-fully-signed")
                                }
                                taskAction {
                                    actionKey("multi-action-partially-sign-written-cheque")
                                    actionName("Partially Sign Written Cheque")
                                    actionDescription("Partially Sign Written Cheque")
                                    actionDestinationTask("multi-task-cheque-partially-signed")
                                }
                                taskAction {
                                    actionKey("multi-action-reject-written-cheque")
                                    actionName("Reject Written Cheque")
                                    actionDescription("Reject Written Cheque")
                                    actionDestinationTask("multi-task-cheque-rejected")
                                }
                            }
                        }
                        stage {
                            stageKey("multi-stage-cheque-partially-signed")
                            stageName("Cheque Partially Signed")
                            stageInitialTask {
                                taskKey("multi-task-cheque-partially-signed")
                                taskName("Cheque Partially Signed")
                                taskAction {
                                    actionKey("multi-action-cheque-fully-sign-partially-signed")
                                    actionName("Fully Sign Partially Signed Cheque")
                                    actionDescription("Fully Sign Partially Signed Cheque")
                                    actionDestinationTask("multi-task-cheque-fully-signed")
                                }
                                taskAction {
                                    actionKey("multi-action-cheque-partially-sign-partially-signed")
                                    actionName("Partially Sign Written Cheque")
                                    actionDescription("Partially Sign Cheque")
                                    actionDestinationTask("multi-task-cheque-partially-signed")
                                }
                                taskAction {
                                    actionKey("multi-action-reject-partially-signed-cheque")
                                    actionName("Reject Cheque")
                                    actionDescription("Reject Cheque")
                                    actionDestinationTask("multi-task-cheque-rejected")
                                }
                            }
                        }
                        stage {
                            stageKey("multi-stage-cheque-rejected")
                            stageName("Cheque Rejected")
                            stageTask {
                                taskKey("multi-task-cheque-rejected")
                                taskName("Cheque Rejected")
                            }
                        }
                        stage {
                            stageKey("multi-stage-cheque-cancelled")
                            stageName("Cheque Cancelled")
                            stageTask {
                                taskKey("multi-task-cheque-cancelled")
                                taskName("Cheque Cancelled")
                            }
                        }
                        stage {
                            stageKey("multi-stage-cheque-paid")
                            stageName("Cheque Paid")
                            stageTask {
                                taskKey("multi-task-cheque-paid")
                                taskName("Cheque Paid")
                            }
                        }
                        stage {
                            stageKey("multi-stage-cheque-fully-signed")
                            stageName("Cheque Fully Signed")
                            stageInitialTask {
                                taskKey("multi-task-cheque-fully-signed")
                                taskName("Cheque Fully Signed Cheque")

                                taskAction {
                                    actionKey("multi-action-deposit-signed-cheque")
                                    actionName("Deposit Signed Cheque")
                                    actionDescription("Deposit Signed Cheque")
                                    actionDestinationTask("multi-task-cheque-deposit-requested")
                                }

                                taskAction {
                                    actionKey("multi-action-cancel-signed-cheque")
                                    actionName("Cancel Signed Cheque")
                                    actionDescription("Cancel Signed Cheque")
                                    actionDestinationTask("multi-task-cheque-cancelled")
                                }
                            }
                        }
                    }
                    workflow {
                        key("multi-cheques-workflow-1")
                        name("Multi Cheques Clearing Workflow")
                        description("Multi Cheques Clearing Workflow")
                        stage {
                            stageKey("multi-stage-cheque-deposit-requested")
                            stageName("Cheque Deposit Requested")
                            stageInitialTask {
                                taskKey("multi-task-cheque-deposit-requested")
                                taskName("Cheque Deposit Requested")
                                taskAction {
                                    actionKey("multi-action-approve-cheque-deposit-request")
                                    actionName("Approve Cheque Deposit Request")
                                    actionDescription("Approve Cheque Deposit Request")
                                    actionDestinationTask("multi-task-cheque-deposit-request-approved")
                                }
                                taskAction {
                                    actionKey("multi-action-reject-cheque-deposit-request")
                                    actionName("Reject Cheque Deposit Request")
                                    actionDescription("Reject Cheque Deposit Request")
                                    actionDestinationTask("multi-task-cheque-deposit-request-rejected")
                                }
                            }
                        }
                        stage {
                            stageKey("multi-stage-cheque-deposit-request-approved")
                            stageName("Cheque Deposit Request Approved")
                            stageInitialTask {
                                taskKey("multi-task-cheque-deposit-request-approved")
                                taskName("Cheque Deposit Request Approved")
                                taskAction {
                                    actionKey("multi-action-cheque-deposit-request-pay")
                                    actionName("Pay Cheque")
                                    actionDescription("Pay Cheque")
                                    actionDestinationTask("multi-task-cheque-paid")
                                }
                                taskAction {
                                    actionKey("multi-action-cheque-deposit-request-return")
                                    actionName("Return Cheque")
                                    actionDescription("Return Cheque")
                                    actionDestinationTask("multi-task-cheque-deposit-request-returned")
                                }
                            }
                        }
                        stage {
                            stageKey("multi-stage-cheque-deposit-request-rejected")
                            stageName("Cheque Deposit Rejected")
                            stageInitialTask {
                                taskKey("multi-task-cheque-deposit-request-rejected")
                                taskName("Cheque Deposit Rejected")

                                taskAction {
                                    actionKey("multi-action-deposit-rejected-depositing-cheque")
                                    actionName("Deposit Cheque")
                                    actionDescription("Deposit Rejected Depositing Cheque")
                                    actionDestinationTask("multi-task-cheque-deposit-requested")
                                }

                                taskAction {
                                    actionKey("multi-action-cancel-rejected-depositing-cheque")
                                    actionName("Cancel Signed Cheque")
                                    actionDescription("Cancel Signed Cheque")
                                    actionDestinationTask("multi-task-cheque-cancelled")
                                }
                            }
                        }
                        stage {
                            stageKey("multi-stage-cheque-deposit-request-returned")
                            stageName("Cheque Deposit Returned")
                            stageInitialTask {
                                taskKey("multi-task-cheque-deposit-request-returned")
                                taskName("Cheque Deposit Returned")

                                taskAction {
                                    actionKey("multi-action-deposit-returned-depositing-cheque")
                                    actionName("Deposit Cheque")
                                    actionDescription("Deposit Returned Cheque")
                                    actionDestinationTask("multi-task-cheque-deposit-requested")
                                }

                                taskAction {
                                    actionKey("multi-action-cancel-returned-depositing-cheque")
                                    actionName("Cancel Returned Cheque")
                                    actionDescription("Cancel Returned Cheque")
                                    actionDestinationTask("multi-task-cheque-cancelled")
                                }
                            }
                        }
                    }
                }

                LOGGER.debug("Initializing Multi Cheques Workflow has been done")
            } catch (e: Exception) {
                LOGGER.error("Initializing Multi Cheques Workflow has been failed [Error: {}]", e.message, e)
                transactionStatus.setRollbackOnly()
            }

        }
    }
}
