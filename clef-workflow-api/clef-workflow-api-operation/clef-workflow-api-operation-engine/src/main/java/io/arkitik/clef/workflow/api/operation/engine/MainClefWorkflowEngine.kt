package io.arkitik.clef.workflow.api.operation.engine

import io.arkitik.clef.workflow.api.operation.action.ActionSdkImpl
import io.arkitik.clef.workflow.api.operation.element.ElementSdkImpl
import io.arkitik.clef.workflow.api.operation.stage.StageSdkImpl
import io.arkitik.clef.workflow.api.operation.task.StageTaskSdkImpl
import io.arkitik.clef.workflow.api.operation.workflow.WorkflowSdkImpl
import io.arkitik.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.TaskActionUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 20 11:57 PM, **Mon, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
class MainClefWorkflowEngine(
    taskActionUseCaseFactory: TaskActionUseCaseFactory,
    elementUseCaseFactory: ElementUseCaseFactory,
    stageUseCaseFactory: StageUseCaseFactory,
    taskUseCaseFactory: TaskUseCaseFactory,
    workflowUseCaseFactory: WorkflowUseCaseFactory,
) : ClefWorkflowEngine {

    override val actionSdk = ActionSdkImpl(taskActionUseCaseFactory)

    override val elementSdk = ElementSdkImpl(elementUseCaseFactory)

    override val stageSdk = StageSdkImpl(stageUseCaseFactory)

    override val stageTaskSdk = StageTaskSdkImpl(taskUseCaseFactory)

    override val workflowSdk = WorkflowSdkImpl(workflowUseCaseFactory)

}