package io.arkitik.clef.workflow.api.store.action

import io.arkitik.radix.develop.store.Store
import io.arkitik.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.arkitik.clef.workflow.api.store.action.creator.TaskActionCreator
import io.arkitik.clef.workflow.api.store.action.creator.TaskActionParameterCreator
import io.arkitik.clef.workflow.api.store.action.query.TaskActionStoreQuery
import io.arkitik.clef.workflow.api.store.action.updater.TaskActionUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskActionStore : Store<String, TaskActionIdentity> {
    override val storeQuery: TaskActionStoreQuery

    override fun identityCreator(): TaskActionCreator

    override fun TaskActionIdentity.identityUpdater(): TaskActionUpdater

    fun taskActionParameterCreator(): TaskActionParameterCreator
}