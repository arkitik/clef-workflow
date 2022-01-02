package io.arkitik.clef.workflow.api.store.task.query

import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.radix.develop.store.query.StoreQuery

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface TaskStoreQuery : StoreQuery<String, TaskIdentity> {
    fun findByKey(
        taskKey: String,
    ): TaskIdentity?

    fun existByKey(domainKey: String): Boolean

    fun findAllByStage(
        stage: StageIdentity,
    ): List<TaskIdentity>
}
