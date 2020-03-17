package io.quee.clef.workflow.api.deploy.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@SpringBootApplication(scanBasePackages = [
    "io.quee.clef.workflow.api.controller.*",
    "io.quee.clef.workflow.api.adapter.*",
    "io.quee.clef.workflow.api.port.*"
])
class ClefWorkflowApplication

fun main(args: Array<String>) {
    runApplication<ClefWorkflowApplication>(*args)
}