package io.arkitik.clef.workflow.api.adapter.action.creator

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.action.ActionParameterIdentity
import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.entity.action.ActionParameter
import io.arkitik.clef.workflow.api.store.action.creator.ActionParameterCreator
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **25**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ActionParameterCreatorImpl : ActionParameterCreator {
    private lateinit var parameterKey: String
    private lateinit var parameterValue: String
    private lateinit var action: ActionIdentity
    private var uuid = UUID.randomUUID().toString().replace("-", "")

    override fun ActionIdentity.action(): ActionParameterCreator {
        action = this
        return this@ActionParameterCreatorImpl
    }

    override fun String.uuid(): StoreIdentityCreator<String, ActionParameterIdentity> {
        uuid = this
        return this@ActionParameterCreatorImpl
    }

    override fun String.parameterKey(): ActionParameterCreator {
        parameterKey = this
        return this@ActionParameterCreatorImpl
    }

    override fun String.parameterValue(): ActionParameterCreator {
        parameterValue = this
        return this@ActionParameterCreatorImpl
    }

    override fun create() =
        ActionParameter(
            parameterKey = parameterKey,
            parameterValue = parameterValue,
            action = action as Action,
            uuid = uuid
        )
}
