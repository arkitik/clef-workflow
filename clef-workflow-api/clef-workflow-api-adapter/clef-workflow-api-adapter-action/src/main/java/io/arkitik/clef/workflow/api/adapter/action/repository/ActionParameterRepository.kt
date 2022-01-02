package io.arkitik.clef.workflow.api.adapter.action.repository

import io.arkitik.clef.workflow.api.entity.action.Action
import io.arkitik.clef.workflow.api.entity.action.ActionParameter
import io.arkitik.radix.adapter.shared.repository.RadixRepository

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
interface ActionParameterRepository : RadixRepository<String, ActionParameter> {
    fun findAllByAction(action: Action): List<ActionParameter>
}
