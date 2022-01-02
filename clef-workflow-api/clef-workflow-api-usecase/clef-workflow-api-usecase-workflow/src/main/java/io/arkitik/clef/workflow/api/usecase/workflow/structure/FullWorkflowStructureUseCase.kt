package io.arkitik.clef.workflow.api.usecase.workflow.structure

import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.stage.StageDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.task.TaskDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.workflow.WorkflowDomainRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.FullWorkflowStructure
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.StageStructure
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.TaskActionStructure
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.TaskStructure
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.WorkflowStructure
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class FullWorkflowStructureUseCase(
    private val workflowStoreQuery: WorkflowStoreQuery,
    private val stageDomainUseCaseFactory: StageDomainUseCaseFactory,
    private val taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
    private val actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
) : ValidationFunctionalUseCase<UseCaseRequest, FullWorkflowStructure>() {
    override fun UseCaseRequest.doProcess(): FullWorkflowStructure {
        val list = workflowStoreQuery.all()
            .map {
                it.toStructure()
            }
        return FullWorkflowStructure(list)
    }

    private fun WorkflowIdentity.toStructure(): WorkflowStructure {
        val response = stageDomainUseCaseFactory.functional {
            findWorkflowStagesUseCase
        }.process(WorkflowDomainRequest(this))
        return WorkflowStructure(
            workflowUuid = uuid,
            workflowKey = workflowKey,
            workflowName = workflowName,
            status = identityStatus,
            workflowDescription = workflowDescription,
            initialStage = response.initialStage?.toStructure(),
            stages = response.stages.map {
                it.toStructure()
            }
        )
    }

    private fun StageIdentity.toStructure(): StageStructure {
        val stageTasksResponse = taskDomainUseCaseFactory.functional {
            findStageTasksUseCase
        }.process(StageDomainRequest(this))
        return StageStructure(
            stageUuid = uuid,
            stageKey = stageKey,
            stageName = stageName,
            status = identityStatus,
            initialTask = stageTasksResponse.initialTask?.toStructure(),
            tasks = stageTasksResponse.tasks.map {
                it.toStructure()
            })
    }

    private fun TaskIdentity.toStructure(): TaskStructure {
        val response = actionDomainUseCaseFactory.functional {
            findTaskActionsUseCase
        }.process(TaskDomainRequest(this))
        return TaskStructure(uuid, taskKey, taskName, identityStatus,
            response.actions.map {
                it.toStructure()
            })
    }

    private fun ActionIdentity.toStructure(): TaskActionStructure {
        return TaskActionStructure(
            actionUuid = uuid,
            actionKey = actionKey,
            actionName = actionName,
            status = identityStatus,
            actionDescription = actionDescription,
            destinationTask = ViewIdentify(uuid = destinationTask.uuid, key = destinationTask.taskKey)
        )
    }
}
