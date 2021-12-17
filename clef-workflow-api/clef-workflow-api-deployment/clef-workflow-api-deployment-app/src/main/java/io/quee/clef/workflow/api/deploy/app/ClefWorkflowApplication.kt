package io.quee.clef.workflow.api.deploy.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@SpringBootApplication(scanBasePackages = [
    "io.quee.clef.workflow.api.controller.*",
    "io.quee.clef.workflow.api.adapter.*",
    "io.quee.clef.workflow.api.port.*",
    "io.quee.clef.workflow.integration.*"
])
@EnableJpaRepositories(basePackages = ["io.quee.clef.workflow.api.adapter.*"])
@EntityScan(basePackages = [
    "io.quee.clef.workflow.api.entity"
])
class ClefWorkflowApplication

fun main(args: Array<String>) {
    runApplication<ClefWorkflowApplication>(*args)
}