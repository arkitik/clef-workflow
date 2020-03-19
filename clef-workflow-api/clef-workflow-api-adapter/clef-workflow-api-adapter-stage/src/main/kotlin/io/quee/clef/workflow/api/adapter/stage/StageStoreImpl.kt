package io.quee.clef.workflow.api.adapter.stage

import io.quee.clef.workflow.api.adapter.entity.WorkflowStage
import io.quee.clef.workflow.api.adapter.shared.StoreImpl
import io.quee.clef.workflow.api.adapter.stage.creator.StageIdentityCreatorImpl
import io.quee.clef.workflow.api.adapter.stage.query.StageStoreQueryImpl
import io.quee.clef.workflow.api.adapter.stage.repository.WorkflowStageRepository
import io.quee.clef.workflow.api.adapter.stage.updater.StageIdentityUpdaterImpl
import io.quee.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.quee.clef.workflow.api.store.stage.StageStore
import io.quee.clef.workflow.api.store.stage.creator.StageIdentityCreator
import io.quee.clef.workflow.api.store.stage.query.StageStoreQuery
import io.quee.clef.workflow.api.store.stage.updater.StageIdentityUpdater
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Service
class StageStoreImpl(
        workflowStageRepository: WorkflowStageRepository
) : StoreImpl<StageIdentity, WorkflowStage>(workflowStageRepository), StageStore {
    override fun StageIdentity.map(): WorkflowStage = this as WorkflowStage

    override val storeQuery: StageStoreQuery = StageStoreQueryImpl(workflowStageRepository)

    override fun identityCreator(): StageIdentityCreator =
            StageIdentityCreatorImpl()

    override fun StageIdentity.identityUpdater(): StageIdentityUpdater =
            StageIdentityUpdaterImpl(map())
}