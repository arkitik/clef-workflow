package io.arkitik.clef.workflow.api.usecase.workflow.main

//import io.arkitik.api.develop.shared.exception.NotAcceptableException
//import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus
//import io.arkitik.radix.develop.usecase.UseCaseException
//import io.arkitik.radix.develop.usecase.model.UseCaseRequest
//import io.arkitik.clef.workflow.api.common.error.WorkflowResponses
//import io.arkitik.clef.workflow.api.function.shared.IdentityStatusValidation
//import io.arkitik.clef.workflow.api.store.workflow.FakeWorkflowStore
//import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Assertions.assertNotNull
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.assertThrows

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
//internal class DisableWorkflowUseCaseTest {
//    @Test
//    internal fun `Given invalid request data, error should be thrown`() {
//        val request = object : WorkflowRequest<UseCaseRequest> {
//            override val request: UseCaseRequest = UseCaseRequest.NOP
//            override val workflowKey: String = ""
//            override val workflowUuid: String = ""
//
//        }
//        val exception = assertThrows<UseCaseException> {
//            DisableWorkflowUseCase(FakeWorkflowStore(), IdentityStatusValidation())
//                    .run {
//                        request.process()
//                    }
//        }
//        assertEquals(exception.errors.size, 3)
//    }
//
//    @Test
//    internal fun `Given invalid workflowKey request, error should be thrown`() {
//        val request = object : WorkflowRequest<UseCaseRequest> {
//            override val request: UseCaseRequest = UseCaseRequest.NOP
//            override val workflowKey: String = "invalid regex"
//            override val workflowUuid: String = "Valid Uuid"
//
//        }
//        val exception = assertThrows<UseCaseException> {
//            DisableWorkflowUseCase(FakeWorkflowStore(), IdentityStatusValidation())
//                    .run {
//                        request.process()
//                    }
//        }
//        assertEquals(exception.errors.size, 1)
//        assertEquals(exception.errors[0].code, "workflowKey")
//    }
//
//    @Test
//    internal fun `Given invalid workflowUuid request, error should be thrown`() {
//        val request = object : WorkflowRequest<UseCaseRequest> {
//            override val request: UseCaseRequest = UseCaseRequest.NOP
//            override val workflowKey: String = "valid-key"
//            override val workflowUuid: String = ""
//
//        }
//        val exception = assertThrows<UseCaseException> {
//            DisableWorkflowUseCase(FakeWorkflowStore(), IdentityStatusValidation())
//                    .run {
//                        request.process()
//                    }
//        }
//        assertEquals(exception.errors.size, 1)
//        assertEquals(exception.errors[0].code, "workflowUuid")
//    }
//
//    @Test
//    internal fun `Given valid request but workflowKey not related to any stored workflow, error should be thrown`() {
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
//        val request = object : WorkflowRequest<UseCaseRequest> {
//            override val request: UseCaseRequest = UseCaseRequest.NOP
//            override val workflowKey: String = workflowIdentity.workflowKey + "ANY"
//            override val workflowUuid: String = workflowIdentity.uuid
//
//        }
//        val exception = assertThrows<NotAcceptableException> {
//            DisableWorkflowUseCase(workflowStore, IdentityStatusValidation())
//                    .run {
//                        request.process()
//                    }
//        }
//        assertEquals(exception.error, WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
//    }
//
//    @Test
//    internal fun `Given valid request but workflowUuid not related to any stored workflow, error should be thrown`() {
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
//        val request = object : WorkflowRequest<UseCaseRequest> {
//            override val request: UseCaseRequest = UseCaseRequest.NOP
//            override val workflowKey: String = workflowIdentity.workflowKey
//            override val workflowUuid: String = workflowIdentity.uuid + "ANY"
//
//        }
//        val exception = assertThrows<NotAcceptableException> {
//            DisableWorkflowUseCase(workflowStore, IdentityStatusValidation())
//                    .run {
//                        request.process()
//                    }
//        }
//        assertEquals(exception.error, WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
//    }
//
//    @Test
//    internal fun `Given valid request and workflow deleted already, error should be thrown`() {
//        val workflowStore = FakeWorkflowStore()
//        val workflowIdentity = workflowStore.run {
//            workflowStore.identityCreator()
//                    .run {
//                        "valid-key".workflowKey()
//                        "Workflow Name".workflowName()
//                        "valid-key".workflowDescription()
//                        enable()
//                        create().save()
//                    }
//        }
//        val updatedWorkflow = workflowStore.run {
//            workflowIdentity.identityUpdater()
//                    .run {
//                        delete()
//                        update().save()
//                    }
//        }
//        val request = object : WorkflowRequest<UseCaseRequest> {
//            override val request: UseCaseRequest = UseCaseRequest.NOP
//            override val workflowKey: String = updatedWorkflow.workflowKey
//            override val workflowUuid: String = updatedWorkflow.uuid
//
//        }
//        assertThrows<NotAcceptableException> {
//            DisableWorkflowUseCase(workflowStore, IdentityStatusValidation())
//                    .run {
//                        request.process()
//                    }
//        }
//    }
//
//    @Test
//    internal fun `Given valid request and workflow disabled already, Error will be thrown`() {
//        val workflowStore = FakeWorkflowStore()
//        val workflowIdentity = workflowStore.run {
//            workflowStore.identityCreator()
//                    .run {
//                        "valid-key".workflowKey()
//                        "Workflow Name".workflowName()
//                        "valid-key".workflowDescription()
//                        disable()
//                        create().save()
//                    }
//        }
//        val request = object : WorkflowRequest<UseCaseRequest> {
//            override val request: UseCaseRequest = UseCaseRequest.NOP
//            override val workflowKey: String = workflowIdentity.workflowKey
//            override val workflowUuid: String = workflowIdentity.uuid
//
//        }
//
//        assertThrows<NotAcceptableException> {
//            DisableWorkflowUseCase(workflowStore, IdentityStatusValidation())
//                    .run {
//                        request.process()
//                    }
//        }
//    }
//
//    @Test
//    internal fun `Given valid request and workflow enabled already, Success message should be returned`() {
//        val workflowStore = FakeWorkflowStore()
//        val workflowIdentity = workflowStore.run {
//            workflowStore.identityCreator()
//                    .run {
//                        "valid-key".workflowKey()
//                        "Workflow Name".workflowName()
//                        "valid-key".workflowDescription()
//                        enable()
//                        create().save()
//                    }
//        }
//        val request = object : WorkflowRequest<UseCaseRequest> {
//            override val request: UseCaseRequest = UseCaseRequest.NOP
//            override val workflowKey: String = workflowIdentity.workflowKey
//            override val workflowUuid: String = workflowIdentity.uuid
//
//        }
//        val response = DisableWorkflowUseCase(workflowStore, IdentityStatusValidation())
//                .run {
//                    request.process()
//                }
//        val updatedWorkflow = workflowStore.storeQuery.find(request.workflowUuid)
//        assertEquals(response, WorkflowResponses.WORKFLOW_DISABLED_SUCCESS)
//        assertNotNull(updatedWorkflow)
//        assertEquals(updatedWorkflow?.identityStatus, IdentityStatus.DISABLED)
//    }
//}