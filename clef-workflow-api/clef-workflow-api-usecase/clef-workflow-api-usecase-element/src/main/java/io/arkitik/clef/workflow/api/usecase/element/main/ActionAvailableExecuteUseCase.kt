package io.arkitik.clef.workflow.api.usecase.element.main

import io.arkitik.clef.workflow.api.domain.action.ActionIdentity
import io.arkitik.clef.workflow.api.domain.element.ElementIdentity
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.ElementDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.element.domain.request.ElementKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.element.request.ExecuteActionRequest
import io.arkitik.radix.develop.usecase.FunctionalUseCase
import io.arkitik.radix.develop.usecase.adapter.ResponseAdapter
import io.arkitik.radix.develop.usecase.adapter.adapterProcess
import io.arkitik.radix.develop.usecase.adapter.toResponse
import io.arkitik.radix.develop.usecase.functional

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 17:00, 26 , **Sun, June 2022**
 * Project *clef-workflow* [arkitik.io](https://arkitik.io)
 */
class ActionAvailableExecuteUseCase(
    private val elementDomainUseCaseFactory: ElementDomainUseCaseFactory,
    private val actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
) : FunctionalUseCase<ExecuteActionRequest, ResponseAdapter<Boolean>> {
    override fun ExecuteActionRequest.process(): ResponseAdapter<Boolean> {
        return toResponse {
            val element = elementDomainUseCaseFactory functional {
                findElementByKeyUseCase
            } adapterProcess ElementKeyRequest(element.key)

            val actionToBeExecuted = findAction()
            element.validateActionAvailability(actionToBeExecuted)
        }
    }

    private fun ExecuteActionRequest.findAction() = actionDomainUseCaseFactory functional {
        findActionByKeyUseCase
    } adapterProcess FindDomainByKeyRequest(action.key, false)

    private fun ElementIdentity.validateActionAvailability(action: ActionIdentity): Boolean {
        return action.sourceTask.uuid == task.uuid
    }
}