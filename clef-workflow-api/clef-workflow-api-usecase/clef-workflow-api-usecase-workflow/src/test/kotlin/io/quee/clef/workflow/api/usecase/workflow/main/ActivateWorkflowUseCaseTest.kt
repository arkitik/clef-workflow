package io.quee.clef.workflow.api.usecase.workflow.main

import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.shared.model.IdentityStatus
import io.quee.api.develop.usecase.UseCaseException
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.clef.workflow.api.common.error.WorkflowResponses
import io.quee.clef.workflow.api.function.shared.IdentityStatusValidation
import io.quee.clef.workflow.api.store.workflow.FakeWorkflowStore
import io.quee.clef.workflow.api.usecase.factory.workflow.request.workflow.WorkflowRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
internal class ActivateWorkflowUseCaseTest {
    @Test
    internal fun `Given invalid request data, error should be thrown`() {
        val request = object : WorkflowRequest<UseCaseRequest> {
            override val request: UseCaseRequest = UseCaseRequest.NOP
            override val workflowKey: String = ""
            override val workflowUuid: String = ""

        }
        val exception = assertThrows<UseCaseException> {
            ActivateWorkflowUseCase(FakeWorkflowStore(), IdentityStatusValidation())
                    .run {
                        request.process()
                    }
        }
        assertEquals(exception.errors.size, 3)
    }

    @Test
    internal fun `Given invalid workflowKey request, error should be thrown`() {
        val request = object : WorkflowRequest<UseCaseRequest> {
            override val request: UseCaseRequest = UseCaseRequest.NOP
            override val workflowKey: String = "invalid regex"
            override val workflowUuid: String = "Valid Uuid"

        }
        val exception = assertThrows<UseCaseException> {
            ActivateWorkflowUseCase(FakeWorkflowStore(), IdentityStatusValidation())
                    .run {
                        request.process()
                    }
        }
        assertEquals(exception.errors.size, 1)
        assertEquals(exception.errors[0].code, "workflowKey")
    }

    @Test
    internal fun `Given invalid workflowUuid request, error should be thrown`() {
        val request = object : WorkflowRequest<UseCaseRequest> {
            override val request: UseCaseRequest = UseCaseRequest.NOP
            override val workflowKey: String = "valid-key"
            override val workflowUuid: String = ""

        }
        val exception = assertThrows<UseCaseException> {
            ActivateWorkflowUseCase(FakeWorkflowStore(), IdentityStatusValidation())
                    .run {
                        request.process()
                    }
        }
        assertEquals(exception.errors.size, 1)
        assertEquals(exception.errors[0].code, "workflowUuid")
    }

    @Test
    internal fun `Given valid request but workflowKey not related to any stored workflow, error should be thrown`() {
        val workflowStore = FakeWorkflowStore()
        val workflowIdentity = workflowStore.run {
            workflowStore.identityCreator()
                    .run {
                        "valid-key".workflowKey()
                        "Workflow Name".workflowName()
                        "valid-key".workflowDescription()
                        create().save()
                    }
        }
        val request = object : WorkflowRequest<UseCaseRequest> {
            override val request: UseCaseRequest = UseCaseRequest.NOP
            override val workflowKey: String = workflowIdentity.workflowKey + "ANY"
            override val workflowUuid: String = workflowIdentity.uuid

        }
        val exception = assertThrows<NotAcceptableException> {
            ActivateWorkflowUseCase(workflowStore, IdentityStatusValidation())
                    .run {
                        request.process()
                    }
        }
        assertEquals(exception.error, WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
    }

    @Test
    internal fun `Given valid request but workflowUuid not related to any stored workflow, error should be thrown`() {
        val workflowStore = FakeWorkflowStore()
        val workflowIdentity = workflowStore.run {
            workflowStore.identityCreator()
                    .run {
                        "valid-key".workflowKey()
                        "Workflow Name".workflowName()
                        "valid-key".workflowDescription()
                        create().save()
                    }
        }
        val request = object : WorkflowRequest<UseCaseRequest> {
            override val request: UseCaseRequest = UseCaseRequest.NOP
            override val workflowKey: String = workflowIdentity.workflowKey
            override val workflowUuid: String = workflowIdentity.uuid + "ANY"

        }
        val exception = assertThrows<NotAcceptableException> {
            ActivateWorkflowUseCase(workflowStore, IdentityStatusValidation())
                    .run {
                        request.process()
                    }
        }
        assertEquals(exception.error, WorkflowResponses.Errors.WORKFLOW_DOES_NOT_EXIST)
    }

    @Test
    internal fun `Given valid request and workflow activated already, error should be thrown`() {
        val workflowStore = FakeWorkflowStore()
        val workflowIdentity = workflowStore.run {
            workflowStore.identityCreator()
                    .run {
                        "valid-key".workflowKey()
                        "Workflow Name".workflowName()
                        "valid-key".workflowDescription()
                        enable()
                        create().save()
                    }
        }
        val request = object : WorkflowRequest<UseCaseRequest> {
            override val request: UseCaseRequest = UseCaseRequest.NOP
            override val workflowKey: String = workflowIdentity.workflowKey
            override val workflowUuid: String = workflowIdentity.uuid

        }
        assertThrows<NotAcceptableException> {
            ActivateWorkflowUseCase(workflowStore, IdentityStatusValidation())
                    .run {
                        request.process()
                    }
        }
    }

    @Test
    internal fun `Given valid request and workflow deleted already, error should be thrown`() {
        val workflowStore = FakeWorkflowStore()
        val workflowIdentity = workflowStore.run {
            workflowStore.identityCreator()
                    .run {
                        "valid-key".workflowKey()
                        "Workflow Name".workflowName()
                        "valid-key".workflowDescription()
                        enable()
                        create().save()
                    }
        }
        val updatedWorkflow = workflowStore.run {
            workflowIdentity.identityUpdater()
                    .run {
                        delete()
                        update().save()
                    }
        }
        val request = object : WorkflowRequest<UseCaseRequest> {
            override val request: UseCaseRequest = UseCaseRequest.NOP
            override val workflowKey: String = updatedWorkflow.workflowKey
            override val workflowUuid: String = updatedWorkflow.uuid

        }
        assertThrows<NotAcceptableException> {
            ActivateWorkflowUseCase(workflowStore, IdentityStatusValidation())
                    .run {
                        request.process()
                    }
        }
    }

    @Test
    internal fun `Given valid request and workflow disabled already, Success message should be returned`() {
        val workflowStore = FakeWorkflowStore()
        val workflowIdentity = workflowStore.run {
            workflowStore.identityCreator()
                    .run {
                        "valid-key".workflowKey()
                        "Workflow Name".workflowName()
                        "valid-key".workflowDescription()
                        disable()
                        create().save()
                    }
        }
        val request = object : WorkflowRequest<UseCaseRequest> {
            override val request: UseCaseRequest = UseCaseRequest.NOP
            override val workflowKey: String = workflowIdentity.workflowKey
            override val workflowUuid: String = workflowIdentity.uuid

        }
        val response = ActivateWorkflowUseCase(workflowStore, IdentityStatusValidation())
                .run {
                    request.process()
                }
        val updatedWorkflow = workflowStore.storeQuery.find(request.workflowUuid)
        assertEquals(response, WorkflowResponses.WORKFLOW_ACTIVATED_SUCCESS)
        assertNotNull(updatedWorkflow)
        assertEquals(updatedWorkflow?.identityStatus, IdentityStatus.ENABLED)
    }
}