package io.arkitik.clef.workflow.api.domain.stage

import io.arkitik.clef.workflow.api.domain.workflow.WorkflowIdentity
import io.arkitik.radix.develop.identity.Identity

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 4:36 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
interface InitialStageIdentity : Identity<String> {
    override val uuid: String
    val workflow: WorkflowIdentity
    val stage: StageIdentity
}
