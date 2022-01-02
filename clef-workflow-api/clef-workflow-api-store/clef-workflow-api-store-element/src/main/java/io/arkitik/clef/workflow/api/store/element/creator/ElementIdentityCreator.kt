package io.arkitik.clef.workflow.api.store.element.creator

import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **19**, **Thu Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ElementIdentityCreator : StoreIdentityCreator<String, ElementIdentity> {
    fun String.elementKey(): ElementIdentityCreator
    fun TaskIdentity.currentTask(): ElementIdentityCreator
}
