package io.arkitik.clef.workflow.api.store.stage.creator

import io.arkitik.clef.workflow.api.domain.stage.InitialStageIdentity
import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface InitialStageCreator : StoreIdentityCreator<String, InitialStageIdentity> {
    fun WorkflowIdentity.workflow(): InitialStageCreator
    fun StageIdentity.stage(): InitialStageCreator
}
