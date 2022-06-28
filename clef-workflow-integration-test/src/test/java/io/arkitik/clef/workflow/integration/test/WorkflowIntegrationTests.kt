package io.arkitik.clef.workflow.integration.test

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 02 8:43 PM, **Sun, January 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
internal class WorkflowIntegrationTests {
    @TestFactory
    internal fun `sample test`(): List<DynamicTest> {
        return runTestCases(javaClass.classLoader.getResourceAsStream("workflow-scenarios.json")!!)
    }
}
