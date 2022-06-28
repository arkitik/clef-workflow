package io.arkitik.clef.workflow.integration.test

import com.google.gson.JsonObject
import io.arkitik.arch.core.ArchTestingTool
import io.arkitik.arch.core.dto.ResponseType
import io.arkitik.arch.core.dto.TestCase
import io.arkitik.arch.core.dto.TestClassData
import io.arkitik.arch.core.dto.TestSpecification
import io.arkitik.arch.core.parser.JacksonDataParser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.fail
import org.springframework.web.reactive.function.client.WebClientResponseException
import java.io.InputStream
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Thursday **16**, July 2020**
 */
val dataParser = JacksonDataParser()

val archTestingTool: ArchTestingTool = ArchTestingTool.create(
    dataParser,
    "http://localhost:9080",
    testCaseSignatureCreator = {
        ""
    }
)

fun runTestCases(classData: TestClassData) =
    archTestingTool.run(
        classData,
        String::class,
        successCall,
        failCall
    )

fun runTestCases(jsonObject: JsonObject): List<DynamicTest> {
    return with(dataParser) {
        runTestCases(jsonObject.toString().parse(TestClassData::class))
    }
}

fun runTestCases(inputStream: InputStream) =
    archTestingTool.run(inputStream, String::class, successCall = successCall, failCall = failCall)

private val successCall: (TestCase, String?) -> Unit = { testCase, response ->
    if (testCase.responseType == ResponseType.SUCCESS) {
        dataParser.run {
            val map: Map<*, *> = response!!.parse(Map::class)
            map.forEach { responseEntry ->
                testCase.testResponse(response)
//                assertEquals(testCase.response[responseEntry.key], responseEntry.value)
            }
        }
    } else {
        fail("Unexpected to be here")
    }
}
private val failCall: (TestCase, Throwable) -> Unit = { testCase, throwable ->
    if (testCase.responseType != ResponseType.SUCCESS && testCase.responseType.responseException != null) {
        val responseException = throwable as WebClientResponseException
        assertEquals(throwable.javaClass, testCase.responseType.responseException!!.java)
        assertNotNull(responseException.responseBodyAsByteArray)
        testCase.testResponse(responseException.responseBodyAsString)

    } else {
        throwable.printStackTrace()
        if (throwable is WebClientResponseException) {
            fail("Unexpected to be here ${throwable.responseBodyAsString}")
        }
        fail("Unexpected to be here")
    }
}

private fun TestCase.testResponse(responseContent: String) {
    dataParser.run {
        val responseMap: Map<*, *> = responseContent.parse(TreeMap::class)
            .toSortedMap(compareBy<Any> { it.toString().length }.thenBy { it.toString() })
        val responseAsTreeMap = response.toSortedMap(compareBy<Any> { it.toString().length }.thenBy { it.toString() })
        val extraResponseAsTreeMap =
            extraResponse?.toSortedMap(compareBy<Any> { it.toString().length }.thenBy { it.toString() })
        specification.testResponse(responseMap, responseAsTreeMap, extraResponseAsTreeMap)
    }
//    responseMap.forEach { responseEntry ->
//        // TODO Condition is not valid with below assertions
//        if (
//                extraResponse != null &&
//                extraResponse!!.isNotEmpty() &&
//                extraResponse!![responseEntry.key] == responseEntry.value
//        ) {
//            assertEquals(extraResponse!![responseEntry.key], responseEntry.value)
//        } else {
//            if (specification.allowMissing) {
//                if (response.containsKey(responseEntry.key))
//                    assertEquals(response[responseEntry.key], responseEntry.value)
//            } else if (!response.containsKey(responseEntry.key)) {
//                fail("Failed due to missing response key '${responseEntry.key}'")
//            }
//        }
//    }
}

private fun TestSpecification.testResponse(
    responseMap: Map<*, *>,
    expectedResult: Map<*, *>,
    extraExpectedResult: Map<*, *>?,
) {
    responseMap.forEach {
        if (!allowMissingProperties.contains(it.key)) {
            it.value?.testResponseProperties(allowMissingProperties,
                expectedResult[it.key],
                extraExpectedResult?.get(it.key))
        }
    }
}

private fun Any.testResponseProperties(
    allowMissingProperties: List<String>,
    expectedResult: Any?,
    extraExpectedResult: Any?,
) {
    when (this) {
        is Map<*, *> -> {
            if (expectedResult !is Map<*, *>)
                fail("Failed due to invalid response key type [$this], ResponseType : [$javaClass], ExpectedResultType [${expectedResult?.javaClass}]")
            if (extraExpectedResult != null && extraExpectedResult !is Map<*, *>)
                fail("Failed due to invalid response key type [$this], ResponseType : [$javaClass], ExpectedResultType [${expectedResult.javaClass}]")

            val extraExpectedResultMap = extraExpectedResult as? Map<*, *>
            val sorted = this.toSortedMap(compareBy<Any?> { it?.toString()?.length }.thenBy { it.toString() })
            sorted.forEach { (key, value) ->
                if (!allowMissingProperties.contains(key)) {
                    if (!expectedResult.containsKey(key) || extraExpectedResultMap?.containsKey(key) == false)
                        fail("Failed due to missing response key [$key]  as [${value?.javaClass}]")
                    value?.testResponseProperties(allowMissingProperties,
                        expectedResult[key]!!,
                        extraExpectedResultMap?.get(key))
                }
            }
        }
        is Collection<*> -> {
            val expectedResultElements = expectedResult as Collection<*>
            assertIterableEquals(
                this.toSortedSet(compareBy<Any?> { it?.toString()?.length }.thenBy { it.toString() }),
                expectedResultElements.toSortedSet(compareBy<Any?> { it?.toString()?.length }.thenBy { it.toString() })
            )
        }
        else -> {
            if (this != extraExpectedResult) {
                assertEquals(expectedResult, this)
            }
            if (this != extraExpectedResult && this != expectedResult)
                fail("Invalid expected result [$expectedResult] while actual response is [$this] as [$javaClass]")
        }
    }
}
