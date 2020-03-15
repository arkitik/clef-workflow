package io.quee.clef.workflow.api.usecase.workflow

import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.workflow.FakeWorkflowStore
import io.quee.clef.workflow.api.usecase.workflow.main.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
internal class WorkflowUseCaseFactoryImplTest {
    @Test
    internal fun `when create new instance, All property should be filled with valid values`() {
        val workflowStore = FakeWorkflowStore()
        val validation = IdentityStatusValidation()
        val workflowUseCaseFactory = WorkflowUseCaseFactoryImpl(workflowStore, validation)
        assertTrue(workflowUseCaseFactory.activateWorkflowUseCase is ActivateWorkflowUseCase)
        assertTrue(workflowUseCaseFactory.createWorkflowUseCase is CreateWorkflowUseCase)
        assertTrue(workflowUseCaseFactory.deleteWorkflowUseCase is DeleteWorkflowUseCase)
        assertTrue(workflowUseCaseFactory.deactivateWorkflowUseCase is DisableWorkflowUseCase)
        assertTrue(workflowUseCaseFactory.workflowDetailsUseCase is WorkflowDetailsUseCase)
    }
}