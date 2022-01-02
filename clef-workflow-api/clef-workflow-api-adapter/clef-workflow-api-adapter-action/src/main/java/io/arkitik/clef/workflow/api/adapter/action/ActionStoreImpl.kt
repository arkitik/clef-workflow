package io.arkitik.clef.workflow.api.adapter.action

import io.arkitik.clef.workflow.api.adapter.action.creator.ActionCreatorImpl
import io.arkitik.clef.workflow.api.adapter.action.query.ActionStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.action.repository.TaskActionRepository
import io.arkitik.clef.workflow.api.adapter.action.updater.ActionUpdaterImpl
import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.store.action.ActionStore
import io.arkitik.radix.adapter.shared.StoreImpl
import org.springframework.stereotype.Service

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@Service
class ActionStoreImpl(
    taskActionRepository: TaskActionRepository,
) : StoreImpl<String, ActionIdentity, Action>(taskActionRepository), ActionStore {
    override fun ActionIdentity.map(): Action = this as Action

    override val storeQuery = ActionStoreQueryImpl(taskActionRepository)

    override fun identityCreator() = ActionCreatorImpl()
    override fun ActionIdentity.identityUpdater() = ActionUpdaterImpl(map())
}
