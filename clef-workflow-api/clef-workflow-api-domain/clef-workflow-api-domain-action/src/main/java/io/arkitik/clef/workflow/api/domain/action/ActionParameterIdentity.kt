package io.arkitik.clef.workflow.api.domain.action

import io.arkitik.radix.develop.identity.Identity

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionParameterIdentity : Identity<String> {
    override val uuid: String
    val action: ActionIdentity
    val parameterKey: String
    val parameterValue: String
}
