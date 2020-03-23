package io.quee.clef.workflow.integration.spring.boot.starter

import io.quee.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskActionUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.WorkflowUseCaseFactory
import io.quee.clef.workflow.integration.engine.ClefWorkflowEngine
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **23**, **Mon Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@Configuration
@ConditionalOnClass(ClefWorkflowEngine::class)
class ClefWorkflowConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun clefWorkflowEngine(
            taskActionUseCaseFactory: TaskActionUseCaseFactory,
            elementUseCaseFactory: ElementUseCaseFactory,
            stageUseCaseFactory: StageUseCaseFactory,
            taskUseCaseFactory: TaskUseCaseFactory,
            workflowUseCaseFactory: WorkflowUseCaseFactory
    ): ClefWorkflowEngine = MainClefWorkflowEngine(
            taskActionUseCaseFactory,
            elementUseCaseFactory,
            stageUseCaseFactory,
            taskUseCaseFactory,
            workflowUseCaseFactory
    )
}