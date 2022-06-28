package io.arkitik.clef.workflow.api.function.action.bean.store

import io.arkitik.clef.workflow.api.function.action.ActionBean

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17:08, 26 , **Sun, June 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
interface ActionBeanStore {
    fun findBean(
        actionCode: String
    ): ActionBean?
}