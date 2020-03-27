package io.quee.clef.workflow.api.store.action

import io.quee.api.develop.store.Store
import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.store.action.creator.TaskActionCreator
import io.quee.clef.workflow.api.store.action.creator.TaskActionParameterCreator
import io.quee.clef.workflow.api.store.action.query.TaskActionStoreQuery
import io.quee.clef.workflow.api.store.action.updater.TaskActionUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface TaskActionStore : Store<TaskActionIdentity> {
    override val storeQuery: TaskActionStoreQuery

    override fun identityCreator(): TaskActionCreator

    override fun TaskActionIdentity.identityUpdater(): TaskActionUpdater

    fun taskActionParameterCreator(): TaskActionParameterCreator
}