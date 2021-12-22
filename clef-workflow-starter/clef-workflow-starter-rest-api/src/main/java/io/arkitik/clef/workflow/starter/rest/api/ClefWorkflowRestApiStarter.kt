package io.arkitik.clef.workflow.starter.rest.api

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 21 12:24 AM, **Tue, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
@Configuration
@ComponentScan(
    basePackages = ["io.arkitik.clef.workflow.api.controller.*"]
)
class ClefWorkflowRestApiStarter