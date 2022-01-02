package io.arkitik.clef.workflow.api.adapter.stage

import io.arkitik.clef.workflow.api.adapter.stage.creator.InitialStageCreatorImpl
import io.arkitik.clef.workflow.api.adapter.stage.query.InitialStageStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.stage.repository.InitialStageRepository
import io.arkitik.clef.workflow.api.adapter.stage.updater.InitialStageUpdaterImpl
import io.arkitik.clef.workflow.api.domain.stage.InitialStageIdentity
import io.arkitik.clef.workflow.api.entity.stage.InitialStage
import io.arkitik.clef.workflow.api.store.stage.InitialStageStore
import io.arkitik.clef.workflow.api.store.stage.creator.InitialStageCreator
import io.arkitik.clef.workflow.api.store.stage.query.InitialStageStoreQuery
import io.arkitik.clef.workflow.api.store.stage.updater.InitialStageUpdater
import io.arkitik.radix.adapter.shared.StoreImpl
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class InitialInitialStageStoreImpl(
    initialStageRepository: InitialStageRepository,
) : StoreImpl<String, InitialStageIdentity, InitialStage>(initialStageRepository), InitialStageStore {
    override fun InitialStageIdentity.map() = this as InitialStage

    override val storeQuery: InitialStageStoreQuery = InitialStageStoreQueryImpl(initialStageRepository)

    override fun identityCreator(): InitialStageCreator =
        InitialStageCreatorImpl()

    override fun InitialStageIdentity.identityUpdater(): InitialStageUpdater =
        InitialStageUpdaterImpl(map())
}
