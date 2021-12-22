package io.arkitik.clef.workflow.api.store.task

import io.arkitik.radix.develop.store.Store
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.arkitik.clef.workflow.api.store.task.creator.StageTaskCreator
import io.arkitik.clef.workflow.api.store.task.query.StageTaskStoreQuery
import io.arkitik.clef.workflow.api.store.task.updater.StageTaskUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageTaskStore : Store<String,StageTaskIdentity> {
    override val storeQuery: StageTaskStoreQuery

    override fun identityCreator(): StageTaskCreator

    override fun StageTaskIdentity.identityUpdater(): StageTaskUpdater
}