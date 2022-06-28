package io.arkitik.clef.workflow.starter.spring.boot.function

import io.arkitik.clef.workflow.api.function.action.ActionBean
import io.arkitik.radix.develop.shared.error.Error
import io.arkitik.radix.develop.shared.exception.InternalException
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.ListableBeanFactory
import org.springframework.beans.factory.getBeansOfType

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17:55, 26 , **Sun, June 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class SpringActionBeanStoreValidator(
    private val listableBeanFactory: ListableBeanFactory
) : InitializingBean {
    override fun afterPropertiesSet() {
        val entries = listableBeanFactory.getBeansOfType<ActionBean>()
        val uniqueEntries = entries.values.distinctBy { it.actionCode }
        if (entries.size != uniqueEntries.size) {
            throw InternalException(
                Error(
                    "INIT",
                    "Duplicated action beans found"
                )
            )
        }
    }
}