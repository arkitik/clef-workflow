package io.quee.clef.workflow.api.usecase.workflow.structure

import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase
import io.arkitik.radix.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.workflow.query.WorkflowStoreQuery
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.FullWorkflowStructure
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.StageStructure
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.TaskActionStructure
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.TaskStructure
import io.quee.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture.WorkflowStructure

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FullWorkflowStructureUseCase(
    private val workflowStoreQuery: WorkflowStoreQuery,
) : ValidationFunctionalUseCase<UseCaseRequest, FullWorkflowStructure>() {
    override fun UseCaseRequest.doProcess(): FullWorkflowStructure {
        val list = workflowStoreQuery.all()
            .map {
                it.toStructure()
            }
        return FullWorkflowStructure(list)
    }

    private fun WorkflowIdentity.toStructure(): WorkflowStructure {
        return WorkflowStructure(
            uuid,
            workflowKey,
            workflowName,
            identityStatus,
            workflowDescription,
            initialStage.toOptionalStructure(),
            stages.map {
                it.toStructure()
            }
        )
    }

    private fun StageIdentity?.toOptionalStructure(): StageStructure? = this?.toStructure()

    private fun StageIdentity.toStructure(): StageStructure {
        return StageStructure(uuid, stageKey, stageName, identityStatus, initialTask.toOptionalStructure(), tasks.map {
            it.toStructure()
        })
    }

    private fun StageTaskIdentity?.toOptionalStructure(): TaskStructure? = this?.toStructure()
    private fun StageTaskIdentity.toStructure(): TaskStructure {
        return TaskStructure(uuid, taskKey, taskName, identityStatus, actions.map {
            it.toStructure()
        })
    }

    private fun TaskActionIdentity.toStructure(): TaskActionStructure {
        return TaskActionStructure(
            uuid,
            actionKey,
            actionName,
            identityStatus,
            actionDescription,
            ViewIdentify(destinationTask.uuid, destinationTask.taskKey)
        )
    }
}