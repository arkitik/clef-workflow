package io.quee.clef.workflow.api.adapter.stage.query

import io.quee.clef.workflow.api.adapter.entity.WorkflowStage
import io.quee.clef.workflow.api.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.adapter.stage.repository.WorkflowStageRepository
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.stage.query.StageStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageStoreQueryImpl(
        private val workflowStageRepository: WorkflowStageRepository
) : StoreQueryImpl<StageIdentity, WorkflowStage>(workflowStageRepository), StageStoreQuery {
    override fun findByKeyAndUuid(stageKey: String, stageUuid: String): StageIdentity? =
            workflowStageRepository.findByStageKeyAndUuid(stageKey, stageUuid)

    override fun existByKey(stageKey: String): Boolean =
            workflowStageRepository.existsByStageKey(stageKey)
}