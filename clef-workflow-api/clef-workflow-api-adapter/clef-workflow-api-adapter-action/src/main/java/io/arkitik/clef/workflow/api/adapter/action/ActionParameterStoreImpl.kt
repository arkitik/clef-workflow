package io.arkitik.clef.workflow.api.adapter.action

import io.arkitik.clef.workflow.api.adapter.action.creator.ActionParameterCreatorImpl
import io.arkitik.clef.workflow.api.adapter.action.query.ActionParameterStoreQueryImpl
import io.arkitik.clef.workflow.api.adapter.action.repository.ActionParameterRepository
import io.arkitik.clef.workflow.api.adapter.action.updater.ActionParameterUpdaterImpl
import io.arkitik.clef.workflow.api.domain.action.ActionParameterIdentity
import io.arkitik.clef.workflow.api.entity.action.ActionParameter
import io.arkitik.clef.workflow.api.store.action.ActionParameterStore
import io.arkitik.radix.adapter.shared.StoreImpl
import org.springframework.stereotype.Service

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 01 5:28 PM, **Sat, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
@Service
class ActionParameterStoreImpl(
    actionParameterRepository: ActionParameterRepository,
) : StoreImpl<String, ActionParameterIdentity, ActionParameter>(actionParameterRepository), ActionParameterStore {

    override fun ActionParameterIdentity.map() = this as ActionParameter

    override val storeQuery =
        ActionParameterStoreQueryImpl(actionParameterRepository)

    override fun identityCreator() =
        ActionParameterCreatorImpl()

    override fun ActionParameterIdentity.identityUpdater() =
        ActionParameterUpdaterImpl(map())
}
