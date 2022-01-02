package io.arkitik.clef.workflow.api.adapter.task.query

import io.arkitik.clef.workflow.api.adapter.task.repository.InitialTaskRepository
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.task.InitialTaskIdentity
import io.arkitik.clef.workflow.api.entity.stage.Stage
import io.arkitik.clef.workflow.api.entity.task.InitialTask
import io.arkitik.clef.workflow.api.store.task.query.InitialTaskStoreQuery
import io.arkitik.radix.adapter.shared.query.StoreQueryImpl

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:53 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class InitialTaskStoreQueryImpl(
    private val initialTaskRepository: InitialTaskRepository,
) : StoreQueryImpl<String, InitialTaskIdentity, InitialTask>(initialTaskRepository), InitialTaskStoreQuery {
    override fun existsByStage(stage: StageIdentity) =
        initialTaskRepository.existsByStage(stage as Stage)

    override fun findByStage(stage: StageIdentity) =
        initialTaskRepository.findByStage(stage as Stage)
}
