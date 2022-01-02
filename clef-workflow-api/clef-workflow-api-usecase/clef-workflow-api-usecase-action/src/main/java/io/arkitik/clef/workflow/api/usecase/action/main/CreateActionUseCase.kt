package io.arkitik.clef.workflow.api.usecase.action.main

import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.store.action.ActionParameterStore
import io.arkitik.clef.workflow.api.store.action.ActionStore
import io.arkitik.clef.workflow.api.usecase.factory.domain.TaskDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.ExistByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.DomainKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.CreateTaskActionRequest
import io.arkitik.radix.develop.store.storeCreator
import io.arkitik.radix.develop.usecase.command
import io.arkitik.radix.develop.usecase.execute
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class CreateActionUseCase(
    private val actionStore: ActionStore,
    private val actionParameterStore: ActionParameterStore,
    private val actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
    private val taskDomainUseCaseFactory: TaskDomainUseCaseFactory,
) : ValidationFunctionalUseCase<CreateTaskActionRequest, ViewIdentify>() {
    override fun CreateTaskActionRequest.doBefore() {
        actionDomainUseCaseFactory command {
            validateActionExistenceUseCase
        } execute ExistByKeyRequest(actionKey)
    }

    override fun CreateTaskActionRequest.doProcess(): ViewIdentify {
        val sourceTaskIdentify = findTaskIdentify(sourceTask)
        val destinationTaskIdentify = findTaskIdentify(destinationTask)
        val taskAction = actionStore.run {
            storeCreator(identityCreator()) {
                actionDescription.actionDescription()
                actionKey.actionKey()
                actionName.actionName()
                sourceTaskIdentify.sourceTask()
                destinationTaskIdentify.destinationTask()
                create()
            }.save()
        }
        actionParameterStore.run {
            parameters.map {
                storeCreator(identityCreator()) {
                    it.parameterKey.parameterKey()
                    it.parameterValue.parameterValue()
                    taskAction.action()
                    create()
                }
            }.save()
        }
        return ViewIdentify(taskAction.uuid, taskAction.actionKey)
    }

    private fun findTaskIdentify(taskIdentify: DomainKeyRequest): TaskIdentity {
        return (taskDomainUseCaseFactory.functional {
            findTaskByKeyUseCase
        } process FindDomainByKeyRequest(taskIdentify.key, false)).response
    }
}
