package io.arkitik.clef.workflow.api.usecase.workflow.main

//import io.arkitik.api.develop.shared.exception.NotAcceptableException
//import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
//import io.arkitik.radix.develop.usecase.UseCaseException
//import io.arkitik.clef.workflow.api.common.error.WorkflowResponses
//import io.arkitik.clef.workflow.api.store.workflow.FakeWorkflowStore
//import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.CreateWorkflowRequest
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.assertThrows

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
//internal class CreateWorkflowUseCaseTest {
//    @Test
//    internal fun `Given invalid request, then usecase exception should be thrown`() {
//        val workflowStore = FakeWorkflowStore()
//        val request = object : CreateWorkflowRequest {
//            override val workflowKey: String = ""
//            override val workflowName: String = ""
//            override val workflowDescription: String = ""
//        }
//        val exception = assertThrows<UseCaseException> {
//            CreateWorkflowUseCase(workflowStore,).run {
//                request.process()
//            }
//        }
//        assertEquals(exception.errors.size, 3)
//    }
//
//    @Test
//    internal fun `Given exist key, then not acceptable exception should be thrown`() {
//        val workflowStore = FakeWorkflowStore()
//        val workflowIdentity = workflowStore.run {
//            workflowStore.identityCreator()
//                    .run {
//                        "valid-key".workflowKey()
//                        "Workflow Name".workflowName()
//                        "valid-key".workflowDescription()
//                        create().save()
//                    }
//        }
//        val request = object : CreateWorkflowRequest {
//            override val workflowKey: String = workflowIdentity.workflowKey
//            override val workflowName: String = "Workflow Name"
//            override val workflowDescription: String = "Any description"
//        }
//        val exception = assertThrows<NotAcceptableException> {
//            CreateWorkflowUseCase(workflowStore).run {
//                request.process()
//            }
//        }
//        assertEquals(exception.error, WorkflowResponses.Errors.DUPLICATE_WORKFLOW_ERROR)
//    }
//
//    @Test
//    internal fun `Given not exist key, then valid response should be returned`() {
//        val workflowStore = FakeWorkflowStore()
//        val request = object : CreateWorkflowRequest {
//            override val workflowKey: String = "valid-key"
//            override val workflowName: String = "Workflow Name"
//            override val workflowDescription: String = "Any description"
//        }
//        val identify = CreateWorkflowUseCase(workflowStore).run {
//            request.process()
//        }
//        val workflowIdentity = workflowStore.storeQuery.findByKeyAndUuid(identify.key, identify.uuid)
//        assertNotNull(workflowIdentity)
//        assertEquals(workflowIdentity?.workflowKey, request.workflowKey)
//        assertEquals(workflowIdentity?.workflowName, request.workflowName)
//        assertEquals(workflowIdentity?.workflowDescription, request.workflowDescription)
//        assertEquals(workflowIdentity?.identityStatus, IdentityStatus.ENABLED)
//        assertNull(workflowIdentity?.initialStage)
//        assertEquals(workflowIdentity?.stages?.size, 0)
//    }
//}