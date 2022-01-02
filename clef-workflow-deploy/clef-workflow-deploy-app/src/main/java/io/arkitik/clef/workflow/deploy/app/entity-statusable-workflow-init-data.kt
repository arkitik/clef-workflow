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
class EntityStatusWorkflowInitData(
    private val transactionManager: PlatformTransactionManager,
    private val clefWorkflowEngine: ClefWorkflowEngine,
) : CommandLineRunner {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(JobWorkflowInitData::class.java)!!
    }

    override fun run(vararg args: String?) {
        val transactionTemplate = TransactionTemplate(transactionManager)
        transactionTemplate.execute { transactionStatus ->
            LOGGER.debug("Start initializing Entity Status workflow")
            try {
                clefWorkflowEngine.persistWorkflow {
                    workflow {
                        key("entity-status-workflow")
                        name("Entity Status Workflow")
                        description("Entity Status Workflow")
                        initialStage {
                            stageKey("entity-enabled")
                            stageName("Entity Enabled")
                            stageInitialTask {
                                taskKey("enabled-entity")
                                taskName("Entity Enabled")
                                taskAction {
                                    actionKey("disable-entity")
                                    actionName("Mark Entity as disabled")
                                    actionDescription("Disable Entity")
                                    actionDestinationTask("disabled-entity")
                                }
                                taskAction {
                                    actionKey("delete-enabled-entity")
                                    actionName("Mark Entity as deleted")
                                    actionDescription("Delete Entity")
                                    actionDestinationTask("deleted-entity")
                                }
                            }
                        }
                        stage {
                            stageKey("disabled-entity")
                            stageName("Entity Disabled")
                            stageInitialTask {
                                taskKey("disabled-entity")
                                taskName("Entity Disabled")
                                taskAction {
                                    actionKey("enable-entity")
                                    actionName("Mark Entity as enable")
                                    actionDescription("Enable Entity")
                                    actionDestinationTask("enabled-entity")
                                }
                                taskAction {
                                    actionKey("delete-disabled-entity")
                                    actionName("Mark Entity as deleted")
                                    actionDescription("Delete Entity")
                                    actionDestinationTask("deleted-entity")
                                }
                            }
                        }
                        stage {
                            stageKey("deleted-entity")
                            stageName("Entity Deleted")
                            stageInitialTask {
                                taskKey("deleted-entity")
                                taskName("Entity Deleted")
                            }
                        }
                    }
                }

                LOGGER.debug("Initializing Entity Status workflow has been done")
            } catch (e: Exception) {
                LOGGER.error("Initializing Entity Status workflow has been failed [Error: {}]", e.message)
                transactionStatus.setRollbackOnly()
            }

        }
    }
}
