package io.arkitik.clef.workflow.api.store.task.query

import io.arkitik.radix.develop.store.query.StoreQuery
import io.arkitik.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageTaskStoreQuery : StoreQuery<String, StageTaskIdentity> {
    fun findByKey(
        taskKey: String,
    ): StageTaskIdentity?

    fun existByKey(domainKey: String): Boolean
}