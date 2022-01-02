package io.arkitik.clef.workflow.api.store.task

import io.arkitik.radix.develop.store.Store
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.store.task.creator.TaskCreator
import io.arkitik.clef.workflow.api.store.task.query.TaskStoreQuery
import io.arkitik.clef.workflow.api.store.task.updater.TaskUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskStore : Store<String, TaskIdentity> {
    override val storeQuery: TaskStoreQuery

    override fun identityCreator(): TaskCreator

    override fun TaskIdentity.identityUpdater(): TaskUpdater
}
