package io.arkitik.clef.workflow.deploy.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@SpringBootApplication(
    scanBasePackages = [
        "io.arkitik.clef.workflow.api.controller.*",
        "io.arkitik.clef.workflow.deploy"
    ])
class ClefWorkflowApplication

fun main(args: Array<String>) {
    runApplication<ClefWorkflowApplication>(*args)
}