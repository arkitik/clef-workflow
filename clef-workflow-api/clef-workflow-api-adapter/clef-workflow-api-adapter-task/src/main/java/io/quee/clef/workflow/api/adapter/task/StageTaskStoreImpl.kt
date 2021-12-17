package io.quee.clef.workflow.api.adapter.task

import io.arkitik.radix.adapter.shared.StoreImpl
import io.quee.clef.workflow.api.entity.workflow.StageTask
import io.quee.clef.workflow.api.adapter.task.repository.StageTaskRepository
import io.quee.clef.workflow.api.adapter.task.creator.StageTaskCreatorImpl
import io.quee.clef.workflow.api.adapter.task.query.StageTaskStoreQueryImpl
import io.quee.clef.workflow.api.adapter.task.updater.StageTaskUpdaterImpl
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.task.StageTaskStore
import io.quee.clef.workflow.api.store.task.creator.StageTaskCreator
import io.quee.clef.workflow.api.store.task.query.StageTaskStoreQuery
import io.quee.clef.workflow.api.store.task.updater.StageTaskUpdater
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
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