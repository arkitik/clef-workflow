package io.quee.clef.workflow.api.store.action

import io.quee.clef.workflow.api.domain.workflow.stage.action.TaskActionIdentity
import io.quee.clef.workflow.api.store.action.creator.TaskActionCreator
import io.quee.clef.workflow.api.store.action.creator.TaskActionParameterCreator
import io.quee.clef.workflow.api.store.action.query.TaskActionStoreQuery
import io.quee.clef.workflow.api.store.action.updater.TaskActionUpdater

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class FakeTaskActionStore : TaskActionStore {
    override val storeQuery: TaskActionStoreQuery
        get() = TODO("Not yet implemented")

    override fun identityCreator(): TaskActionCreator {
        TODO("Not yet implemented")
    }

    override fun TaskActionIdentity.identityUpdater(): TaskActionUpdater {
        TODO("Not yet implemented")
    }

    override fun taskActionParameterCreator(): TaskActionParameterCreator {
        TODO("Not yet implemented")
    }

    override fun TaskActionIdentity.save(): TaskActionIdentity {
        TODO("Not yet implemented")
    }

    override fun List<TaskActionIdentity>.save(): Iterable<TaskActionIdentity> {
        TODO("Not yet implemented")
    }
}