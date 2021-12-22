package io.arkitik.clef.workflow.api.adapter.stage

import io.arkitik.radix.adapter.shared.StoreImpl
import io.arkitik.clef.workflow.api.entity.workflow.WorkflowStage
import io.arkitik.clef.workflow.api.adapter.stage.creator.StageIdentityCreatorImpl
import io.arkitik.clef.workflow.api.adapter.stage.query.StageStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.stage.repository.WorkflowStageRepository
import io.arkitik.clef.workflow.api.adapter.stage.updater.StageIdentityUpdaterImpl
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.store.stage.creator.StageIdentityCreator
import io.arkitik.clef.workflow.api.store.stage.query.StageStoreQuery
import io.arkitik.clef.workflow.api.store.stage.updater.StageIdentityUpdater
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class StageStoreImpl(
    workflowStageRepository: WorkflowStageRepository,
) : StoreImpl<String, StageIdentity, WorkflowStage>(workflowStageRepository), StageStore {
    override fun StageIdentity.map(): WorkflowStage = this as WorkflowStage

    override val storeQuery: StageStoreQuery = StageStoreQueryImpl(workflowStageRepository)

    override fun identityCreator(): StageIdentityCreator =
        StageIdentityCreatorImpl()

    override fun StageIdentity.identityUpdater(): StageIdentityUpdater =
        StageIdentityUpdaterImpl(map())
}