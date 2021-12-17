package io.quee.clef.workflow.integration.spring.boot.starter

import io.quee.clef.workflow.api.contract.action.ActionContract
import io.quee.clef.workflow.api.contract.element.ElementContract
import io.quee.clef.workflow.api.contract.stage.StageContract
import io.quee.clef.workflow.api.contract.task.StageTaskContract
import io.quee.clef.workflow.api.contract.workflow.WorkflowContract
import io.quee.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskActionUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.quee.clef.workflow.integration.engine.ClefWorkflowEngine
import io.quee.clef.workflow.integration.spring.boot.starter.contract.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **23**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class MainClefWorkflowEngine(
        taskActionUseCaseFactory: TaskActionUseCaseFactory,
        elementUseCaseFactory: ElementUseCaseFactory,
        stageUseCaseFactory: StageUseCaseFactory,
        taskUseCaseFactory: TaskUseCaseFactory,
        workflowUseCaseFactory: WorkflowUseCaseFactory
) : ClefWorkflowEngine {
    override val actionContract: ActionContract = ActionContractImpl(taskActionUseCaseFactory)
    override val elementContract: ElementContract = ElementContractImpl(elementUseCaseFactory)
    override val stageContract: StageContract = StageContractImpl(stageUseCaseFactory)
    override val stageTaskContract: StageTaskContract = StageTaskContractImpl(taskUseCaseFactory)
    override val workflowContract: WorkflowContract = WorkflowContractImpl(workflowUseCaseFactory)
}