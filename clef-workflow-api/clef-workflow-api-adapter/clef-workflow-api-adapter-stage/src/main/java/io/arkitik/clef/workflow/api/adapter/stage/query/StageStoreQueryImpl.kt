package io.arkitik.clef.workflow.api.adapter.stage.query

import io.arkitik.clef.workflow.api.adapter.stage.repository.StageRepository
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.workflow.Workflow
import io.arkitik.clef.workflow.api.store.stage.query.StageStoreQuery
import io.arkitik.radix.adapter.shared.query.StoreQueryImpl

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class StageStoreQueryImpl(
    private val stageRepository: StageRepository,
) : StoreQueryImpl<String, StageIdentity, Stage>(stageRepository), StageStoreQuery {
    override fun findByKeyAndUuid(stageKey: String): StageIdentity? =
        stageRepository.findByStageKey(stageKey)

    override fun existByKey(stageKey: String): Boolean =
        stageRepository.existsByStageKey(stageKey)

    override fun findAllByWorkflow(workflow: WorkflowIdentity) =
        stageRepository.findAllByWorkflow(workflow as Workflow)

}
