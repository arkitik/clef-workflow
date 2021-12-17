package io.quee.clef.workflow.api.adapter.task.query

import io.arkitik.radix.adapter.shared.query.StoreQueryImpl
import io.quee.clef.workflow.api.entity.workflow.StageTask
import io.quee.clef.workflow.api.adapter.task.repository.StageTaskRepository
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity
import io.quee.clef.workflow.api.store.task.query.StageTaskStoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageTaskStoreQueryImpl(
    private val stageTaskRepository: StageTaskRepository,
) : StoreQueryImpl<String, StageTaskIdentity, StageTask>(stageTaskRepository), StageTaskStoreQuery {
    override fun findByKey(taskKey: String): StageTaskIdentity? =
        stageTaskRepository.findByTaskKey(taskKey)

    override fun existByKey(domainKey: String): Boolean =
        stageTaskRepository.existsByTaskKey(domainKey)

}