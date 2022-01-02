package io.arkitik.clef.workflow.starter.spring.boot

import io.arkitik.clef.workflow.api.operation.engine.MainClefWorkflowEngine
import io.arkitik.clef.workflow.api.port.action.ActionContextPort
import io.arkitik.clef.workflow.api.port.element.ElementContextPort
import io.arkitik.clef.workflow.api.port.shared.SharedContextPort
import io.arkitik.clef.workflow.api.port.stage.StageContextPort
import io.arkitik.clef.workflow.api.port.task.TaskContextPort
import io.arkitik.clef.workflow.api.port.workflow.WorkflowContextPort
import io.arkitik.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.ActionUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.arkitik.clef.workflow.sdk.engine.ClefWorkflowEngine
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 21 12:04 AM, **Tue, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
@Configuration
@EnableJpaRepositories(basePackages = ["io.arkitik.clef.workflow.api.adapter.*"])
@EntityScan(basePackages = [
    "io.arkitik.clef.workflow.api.entity"
])
@Import(value = [
    ActionContextPort::class,
    ElementContextPort::class,
    StageContextPort::class,
    TaskContextPort::class,
    WorkflowContextPort::class,
    SharedContextPort::class
])
@ComponentScan(
    basePackages = ["io.arkitik.clef.workflow.api.adapter.*"]
)
class ClefWorkflowStarter {
    @Bean
    fun clefWorkflowEngine(
        actionUseCaseFactory: ActionUseCaseFactory,
        elementUseCaseFactory: ElementUseCaseFactory,
        stageUseCaseFactory: StageUseCaseFactory,
        taskUseCaseFactory: TaskUseCaseFactory,
        workflowUseCaseFactory: WorkflowUseCaseFactory,
    ): ClefWorkflowEngine =
        MainClefWorkflowEngine(
            actionUseCaseFactory = actionUseCaseFactory,
            elementUseCaseFactory = elementUseCaseFactory,
            stageUseCaseFactory = stageUseCaseFactory,
            taskUseCaseFactory = taskUseCaseFactory,
            workflowUseCaseFactory = workflowUseCaseFactory,
        )
}
