package io.arkitik.clef.workflow.api.usecase.workflow

//import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
//import io.arkitik.clef.workflow.api.store.workflow.FakeWorkflowStore
//import io.arkitik.clef.workflow.api.usecase.workflow.main.*
//import org.junit.jupiter.api.Assertions.assertTrue
//import org.junit.jupiter.api.Test

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
//internal class WorkflowUseCaseFactoryImplTest {
//    @Test
//    internal fun `when create new instance, All property should be filled with valid values`() {
//        val workflowStore = FakeWorkflowStore()
//        val validation = IdentityStatusValidation()
//        val workflowUseCaseFactory = WorkflowUseCaseFactoryImpl(workflowStore, validation)
//        assertTrue(workflowUseCaseFactory.activateWorkflowUseCase is ActivateWorkflowUseCase)
//        assertTrue(workflowUseCaseFactory.createWorkflowUseCase is CreateWorkflowUseCase)
//        assertTrue(workflowUseCaseFactory.deleteWorkflowUseCase is DeleteWorkflowUseCase)
//        assertTrue(workflowUseCaseFactory.disableWorkflowUseCase is DisableWorkflowUseCase)
//        assertTrue(workflowUseCaseFactory.workflowDetailsUseCase is WorkflowDetailsUseCase)
//    }
//}