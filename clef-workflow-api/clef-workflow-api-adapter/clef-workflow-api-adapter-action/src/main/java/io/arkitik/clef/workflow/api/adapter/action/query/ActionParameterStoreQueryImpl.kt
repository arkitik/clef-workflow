package io.arkitik.clef.workflow.api.adapter.action.query

import io.arkitik.clef.workflow.api.adapter.action.repository.ActionParameterRepository
import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.action.ActionParameterIdentity
import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.entity.action.ActionParameter
import io.arkitik.clef.workflow.api.store.action.query.ActionParameterStoreQuery
import io.arkitik.radix.adapter.shared.query.StoreQueryImpl

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:30 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class ActionParameterStoreQueryImpl(
    private val actionParameterRepository: ActionParameterRepository,
) : StoreQueryImpl<String, ActionParameterIdentity, ActionParameter>(actionParameterRepository),
    ActionParameterStoreQuery {
    override fun findAllByAction(action: ActionIdentity) =
        actionParameterRepository.findAllByAction(action as Action)
}
