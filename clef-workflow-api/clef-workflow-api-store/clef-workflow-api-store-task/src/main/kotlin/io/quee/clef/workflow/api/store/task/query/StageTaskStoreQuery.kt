package io.quee.clef.workflow.api.store.task.query

import io.quee.api.develop.store.StoreQuery
import io.quee.clef.workflow.api.domain.workflow.stage.task.StageTaskIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
interface StageTaskStoreQuery : StoreQuery<StageTaskIdentity> {
    fun findByKeyAndUuid(
            actionKey: String,
            actionUuid: String
    ): StageTaskIdentity?
}