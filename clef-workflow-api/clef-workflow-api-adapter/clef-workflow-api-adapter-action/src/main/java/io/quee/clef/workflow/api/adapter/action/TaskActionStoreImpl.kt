package io.quee.clef.workflow.api.adapter.action

import io.arkitik.radix.adapter.shared.StoreImpl
import io.quee.clef.workflow.api.adapter.action.creator.TaskActionCreatorImpl
import io.quee.clef.workflow.api.adapter.action.creator.TaskActionParameterCreatorImpl
import io.quee.clef.workflow.api.adapter.action.query.TaskActionStoreQueryImpl
import io.quee.clef.workflow.api.adapter.action.repository.TaskActionRepository
import io.quee.clef.workflow.api.adapter.action.updater.TaskActionUpdaterImpl
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.entity.workflow.TaskAction
import io.quee.clef.workflow.api.store.action.TaskActionStore
import io.quee.clef.workflow.api.store.action.creator.TaskActionCreator
import io.quee.clef.workflow.api.store.action.creator.TaskActionParameterCreator
import io.quee.clef.workflow.api.store.action.query.TaskActionStoreQuery
import io.quee.clef.workflow.api.store.action.updater.TaskActionUpdater
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Service
class TaskActionStoreImpl(
    taskActionRepository: TaskActionRepository,
) : StoreImpl<String, TaskActionIdentity, TaskAction>(taskActionRepository), TaskActionStore {
    override val storeQuery: TaskActionStoreQuery = TaskActionStoreQueryImpl(taskActionRepository)

    override fun identityCreator(): TaskActionCreator = TaskActionCreatorImpl()

    override fun TaskActionIdentity.identityUpdater(): TaskActionUpdater = TaskActionUpdaterImpl(map())

    override fun taskActionParameterCreator(): TaskActionParameterCreator = TaskActionParameterCreatorImpl()

    override fun TaskActionIdentity.map(): TaskAction = this as TaskAction

}