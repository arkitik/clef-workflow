package io.quee.clef.workflow.api.store.task

import io.quee.api.develop.store.Store
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.task.creator.StageTaskCreator
import io.quee.clef.workflow.api.store.task.query.StageTaskStoreQuery
import io.quee.clef.workflow.api.store.task.updater.StageTaskUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageTaskStore : Store<StageTaskIdentity> {
    override val storeQuery: StageTaskStoreQuery

    override fun identityCreator(): StageTaskCreator

    override fun StageTaskIdentity.identityUpdater(): StageTaskUpdater
}