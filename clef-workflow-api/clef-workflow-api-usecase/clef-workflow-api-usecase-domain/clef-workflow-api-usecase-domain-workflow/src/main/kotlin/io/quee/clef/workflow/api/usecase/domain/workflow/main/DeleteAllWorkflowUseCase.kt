package io.quee.clef.workflow.api.usecase.domain.workflow.main

import io.quee.api.develop.action.usecase.validation.ValidationCommandUseCase
import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.workflow.WorkflowStore
import io.quee.clef.workflow.api.usecase.factory.domain.StageDomainUseCaseFactory

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **17**, **Tue Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class DeleteAllWorkflowUseCase(
        private val workflowStore: WorkflowStore,
        private val stageDomainUseCaseFactory: StageDomainUseCaseFactory
) : ValidationCommandUseCase<RequestAdapter<List<WorkflowIdentity>>>() {
    override fun RequestAdapter<List<WorkflowIdentity>>.realExecute() {
        val items = ArrayList(request.map {
            workflowStore.run {
                it.identityUpdater()
                        .delete()
                        .update()
            }
        })
        workflowStore.run {
            items.save()
        }
        val stages = ArrayList<StageIdentity>()
        items.map {
            val itemStages = it.stages
            if (it.initialStage != null)
                stages.add(it.initialStage!!)
            stages.addAll(itemStages)
        }

        stageDomainUseCaseFactory.deleteAllStagesUseCase
                .run {
                    RequestAdapter<List<StageIdentity>>(stages).execute()
                }
    }
}