package io.arkitik.clef.workflow.api.store.action.creator

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.action.ActionParameterIdentity
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionParameterCreator : StoreIdentityCreator<String, ActionParameterIdentity> {
    fun ActionIdentity.action(): ActionParameterCreator
    fun String.parameterKey(): ActionParameterCreator
    fun String.parameterValue(): ActionParameterCreator
}
