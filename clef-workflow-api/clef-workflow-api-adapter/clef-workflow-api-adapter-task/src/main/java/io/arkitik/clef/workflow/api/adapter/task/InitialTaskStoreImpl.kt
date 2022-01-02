package io.arkitik.clef.workflow.api.adapter.task

import io.arkitik.clef.workflow.api.adapter.task.creator.InitialTaskCreatorImpl
import io.arkitik.clef.workflow.api.adapter.task.query.InitialTaskStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.task.repository.InitialTaskRepository
import io.arkitik.clef.workflow.api.adapter.task.updater.InitialTaskUpdaterImpl
import io.arkitik.clef.workflow.api.domain.task.InitialTaskIdentity
import io.arkitik.clef.workflow.api.entity.task.InitialTask
import io.arkitik.clef.workflow.api.store.task.InitialTaskStore
import io.arkitik.radix.adapter.shared.StoreImpl
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class InitialTaskStoreImpl(
    initialTaskRepository: InitialTaskRepository,
) : StoreImpl<String, InitialTaskIdentity, InitialTask>(initialTaskRepository), InitialTaskStore {
    override fun InitialTaskIdentity.map() = this as InitialTask

    override val storeQuery =
        InitialTaskStoreQueryImpl(initialTaskRepository)

    override fun identityCreator() =
        InitialTaskCreatorImpl()

    override fun InitialTaskIdentity.identityUpdater() =
        InitialTaskUpdaterImpl(this as InitialTask)
}
