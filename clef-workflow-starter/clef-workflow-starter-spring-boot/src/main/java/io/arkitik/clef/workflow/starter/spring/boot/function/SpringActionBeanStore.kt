package io.arkitik.clef.workflow.starter.spring.boot.function

import io.arkitik.clef.workflow.api.function.action.ActionBean
import io.arkitik.clef.workflow.api.function.action.bean.store.ActionBeanStore
import org.springframework.beans.factory.ListableBeanFactory
import org.springframework.beans.factory.getBeansOfType

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17:21, 26 , **Sun, June 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class SpringActionBeanStore(
    private val listableBeanFactory: ListableBeanFactory
) : ActionBeanStore {
    override fun findBean(actionCode: String): ActionBean? {
        return listableBeanFactory.getBeansOfType<ActionBean>().values
            .firstOrNull {
                it.actionCode == actionCode
            }
    }
}