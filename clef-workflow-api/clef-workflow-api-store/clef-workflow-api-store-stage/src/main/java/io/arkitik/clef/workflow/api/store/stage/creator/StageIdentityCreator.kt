package io.arkitik.clef.workflow.api.store.stage.creator

import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.clef.workflow.api.domain.workflow.stage.StageIdentity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface StageIdentityCreator : StoreIdentityCreator<String, StageIdentity> {
    fun String.stageKey(): StageIdentityCreator
    fun String.stageName(): StageIdentityCreator
}