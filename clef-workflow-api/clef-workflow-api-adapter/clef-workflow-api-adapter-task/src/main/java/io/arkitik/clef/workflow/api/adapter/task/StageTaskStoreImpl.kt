package io.arkitik.clef.workflow.api.adapter.task

import io.arkitik.radix.adapter.shared.StoreImpl
import io.arkitik.clef.workflow.api.entity.workflow.StageTask
import io.arkitik.clef.workflow.api.adapter.task.repository.StageTaskRepository
import io.arkitik.clef.workflow.api.adapter.task.creator.StageTaskCreatorImpl
import io.arkitik.clef.workflow.api.adapter.task.query.StageTaskStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.task.updater.StageTaskUpdaterImpl
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.store.task.StageTaskStore
import io.arkitik.clef.workflow.api.store.task.creator.StageTaskCreator
import io.arkitik.clef.workflow.api.store.task.query.StageTaskStoreQuery
import io.arkitik.clef.workflow.api.store.task.updater.StageTaskUpdater
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class StageTaskStoreImpl(
    stageTaskRepository: StageTaskRepository,
) : StoreImpl<String, StageTaskIdentity, StageTask>(stageTaskRepository), StageTaskStore {
    override fun StageTaskIdentity.map(): StageTask = this as StageTask

    override val storeQuery: StageTaskStoreQuery =
        StageTaskStoreQueryImpl(stageTaskRepository)

    override fun identityCreator(): StageTaskCreator =
        StageTaskCreatorImpl()

    override fun StageTaskIdentity.identityUpdater(): StageTaskUpdater =
        StageTaskUpdaterImpl(this as StageTask)
}