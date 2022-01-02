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
 * Created At 24 5:27 PM, **Fri, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
@Service
class CreateUpdateDeleteWorkflowInitData(
    private val transactionManager: PlatformTransactionManager,
    private val clefWorkflowEngine: ClefWorkflowEngine,
) : CommandLineRunner {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(JobWorkflowInitData::class.java)!!
    }

    override fun run(vararg args: String?) {
        val transactionTemplate = TransactionTemplate(transactionManager)
        transactionTemplate.execute { transactionStatus ->
            LOGGER.debug("Start initializing Create/Update/Delete workflow")
            try {
                clefWorkflowEngine.persistWorkflow {
                    workflow {
                        key("create-update-workflow")
                        name("Creation/Update Workflow")
                        description("Creation/Update Workflow")
                        initialStage {
                            stageKey("creation-stage")
                            stageName("Creation Stage")
                            stageInitialTask {
                                taskKey("create-entity-task")
                                taskName("Created")
                                taskAction {
                                    actionKey("create-entity")
                                    actionName("Create")
                                    actionDescription("Create")
                                    actionDestinationTask("creation-entity-approval")
                                }
                            }
                            stageTask {
                                taskKey("creation-entity-approval")
                                taskName("Creation Approval")
                                taskAction {
                                    actionKey("approve-create-entity")
                                    actionName("Approve")
                                    actionDescription("Approve")
                                    actionDestinationTask("creation-entity-approved")
                                }
                                taskAction {
                                    actionKey("reject-create-entity")
                                    actionName("Reject")
                                    actionDescription("Reject")
                                    actionDestinationTask("creation-entity-rejected")
                                }
                            }
                            stageTask {
                                taskKey("creation-entity-rejected")
                                taskName("Creation Rejected")
                                taskAction {
                                    actionKey("edit-rejected-create-entity")
                                    actionName("Edit")
                                    actionDescription("Edit")
                                    actionDestinationTask("create-entity-task")
                                }
                            }
                            stageTask {
                                taskKey("creation-entity-approved")
                                taskName("Creation Approved")
                                taskAction {
                                    actionKey("update-approved-create-entity")
                                    actionName("Update")
                                    actionDescription("Update")
                                    actionDestinationTask("update-approval")
                                }
                            }
                        }
                        stage {
                            stageKey("update-approval-stage")
                            stageName("Update Stage")
                            stageInitialTask {
                                taskKey("update-approval")
                                taskName("Update Approval")
                                taskAction {
                                    actionKey("approve-updated-entity")
                                    actionName("Approve")
                                    actionDescription("Approve")
                                    actionDestinationTask("update-approved")
                                }
                                taskAction {
                                    actionKey("reject-updated-entity")
                                    actionName("Reject")
                                    actionDescription("Reject")
                                    actionDestinationTask("update-rejected")
                                }
                            }
                            stageTask {
                                taskKey("update-rejected")
                                taskName("Update Rejected")
                                taskAction {
                                    actionKey("edit-updated-entity")
                                    actionName("Edit")
                                    actionDescription("Edit")
                                    actionDestinationTask("creation-entity-approved")
                                }
                            }
                            stageTask {
                                taskKey("update-approved")
                                taskName("Update Approved")
                                taskAction {
                                    actionKey("delete-approved-updated-entity")
                                    actionName("Delete")
                                    actionDescription("Delete")
                                    actionDestinationTask("deletion-approval")
                                }
                            }
                        }
                        stage {
                            stageKey("deletion-stage")
                            stageName("Deletion Stage")
                            stageInitialTask {
                                taskKey("deletion-approval")
                                taskName("Deletion Approval")
                                taskAction {
                                    actionKey("cancel-entity-deletion")
                                    actionName("Cancel")
                                    actionDescription("Cancel")
                                    actionDestinationTask("update-approved")
                                }
                                taskAction {
                                    actionKey("approve-entity-deletion")
                                    actionName("Approve")
                                    actionDescription("Approve")
                                    actionDestinationTask("deletion-approved")
                                }
                            }
                            stageTask {
                                taskKey("deletion-approved")
                                taskName("Deletion Approved")
                            }
                        }
                    }
                }

                LOGGER.debug("Initializing Create/Update/Delete workflow has been done")
            } catch (e: Exception) {
                LOGGER.error("Initializing Create/Update/Delete workflow has been failed [Error: {}]", e.message)
                transactionStatus.setRollbackOnly()
            }

        }
    }
}
