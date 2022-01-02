package io.arkitik.clef.workflow.api.domain.task

import io.arkitik.clef.workflow.api.domain.stage.StageIdentity
import io.arkitik.radix.develop.identity.Identity

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 4:36 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
interface InitialTaskIdentity : Identity<String> {
    override val uuid: String
    val task: TaskIdentity
    val stage: StageIdentity
}
