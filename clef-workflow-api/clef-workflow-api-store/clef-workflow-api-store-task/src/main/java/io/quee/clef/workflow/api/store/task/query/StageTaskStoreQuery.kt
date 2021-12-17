package io.quee.clef.workflow.api.store.task.query

import io.arkitik.radix.develop.store.query.StoreQuery
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageTaskStoreQuery : StoreQuery<String, StageTaskIdentity> {
    fun findByKey(
        taskKey: String,
    ): StageTaskIdentity?

    fun existByKey(domainKey: String): Boolean
}