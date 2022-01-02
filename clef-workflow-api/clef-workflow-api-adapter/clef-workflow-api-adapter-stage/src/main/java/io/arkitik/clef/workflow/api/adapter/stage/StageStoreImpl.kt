package io.arkitik.clef.workflow.api.adapter.stage

import io.arkitik.clef.workflow.api.adapter.stage.creator.StageCreatorImpl
import io.arkitik.clef.workflow.api.adapter.stage.query.StageStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.stage.repository.StageRepository
import io.arkitik.clef.workflow.api.adapter.stage.updater.StageUpdaterImpl
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.store.stage.StageStore
import io.arkitik.clef.workflow.api.store.stage.creator.StageCreator
import io.arkitik.clef.workflow.api.store.stage.query.StageStoreQuery
import io.arkitik.clef.workflow.api.store.stage.updater.StageUpdater
import io.arkitik.radix.adapter.shared.StoreImpl
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class StageStoreImpl(
    stageRepository: StageRepository,
) : StoreImpl<String, StageIdentity, Stage>(stageRepository), StageStore {
    override fun StageIdentity.map() = this as Stage

    override val storeQuery: StageStoreQuery = StageStoreQueryImpl(stageRepository)

    override fun identityCreator(): StageCreator =
        StageCreatorImpl()

    override fun StageIdentity.identityUpdater(): StageUpdater =
        StageUpdaterImpl(map())
}
