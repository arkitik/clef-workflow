package io.quee.clef.workflow.api.adapter.task.query

import io.quee.clef.workflow.api.adapter.entity.workflow.StageTask
import io.quee.clef.workflow.api.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.adapter.stage.repository.StageTaskRepository
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.task.query.StageTaskStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageTaskStoreQueryImpl(
        private val stageTaskRepository: StageTaskRepository
) : StoreQueryImpl<StageTaskIdentity, StageTask>(stageTaskRepository), StageTaskStoreQuery {
    override fun findByKeyAndUuid(taskKey: String, taskUuid: String): StageTaskIdentity? =
            stageTaskRepository.findByTaskKeyAndUuid(taskKey, taskUuid)

    override fun existByKey(domainKey: String): Boolean =
            stageTaskRepository.existsByTaskKey(domainKey)

}