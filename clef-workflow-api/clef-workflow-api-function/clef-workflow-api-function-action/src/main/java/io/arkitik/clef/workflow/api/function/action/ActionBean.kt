package io.arkitik.clef.workflow.api.function.action

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 16:46, 26 , **Sun, June 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
interface ActionBean {
    val actionCode: String
    fun execute(elementKey: String)
}