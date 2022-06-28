package io.arkitik.clef.workflow.deploy.app.functions

import io.arkitik.clef.workflow.api.function.action.ActionBean
import org.springframework.stereotype.Service

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17:52, 26 , **Sun, June 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
@Service
class MakeChequeFullySigned : ActionBean {
    override val actionCode: String = "action-fully-sign-written-cheque"

    override fun execute(elementKey: String) {
        throw IllegalAccessError(elementKey)
    }
}