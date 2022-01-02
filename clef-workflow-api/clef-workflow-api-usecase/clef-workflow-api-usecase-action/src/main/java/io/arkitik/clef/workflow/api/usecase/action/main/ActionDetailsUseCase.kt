package io.arkitik.clef.workflow.api.usecase.action.main

import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.action.ActionParameterIdentity
import io.arkitik.clef.workflow.api.domain.task.TaskIdentity
import io.arkitik.clef.workflow.api.store.action.query.ActionParameterStoreQuery
import io.arkitik.clef.workflow.api.usecase.factory.domain.ActionDomainUseCaseFactory
import io.arkitik.clef.workflow.api.usecase.factory.domain.request.FindDomainByKeyRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.request.action.TaskActionRequest
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails
import io.arkitik.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionParamDetails
import io.arkitik.radix.develop.usecase.functional
import io.arkitik.radix.develop.usecase.process
import io.arkitik.radix.develop.usecase.validation.functional.ValidationFunctionalUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
class ActionDetailsUseCase(
    private val actionParameterStoreQuery: ActionParameterStoreQuery,
    private val actionDomainUseCaseFactory: ActionDomainUseCaseFactory,
) : ValidationFunctionalUseCase<TaskActionRequest, TaskActionDetails>() {

    override fun TaskActionRequest.doProcess(): TaskActionDetails {
        val action = actionDomainUseCaseFactory.functional {
            findActionByKeyUseCase
        }.process(FindDomainByKeyRequest(actionKey, false)).response
        val parameters = actionParameterStoreQuery.findAllByAction(action)
        return TaskActionDetails(
            action.uuid,
            action.actionKey,
            action.actionName,
            action.actionDescription,
            action.destinationTask.stageViewIdentity(),
            parameters.map {
                it.parameterView()
            }
        )
    }

    private fun TaskIdentity.stageViewIdentity(): ViewIdentify {
        return ViewIdentify(uuid, taskKey)
    }

    private fun ActionParameterIdentity.parameterView(): TaskActionParamDetails {
        return TaskActionParamDetails(parameterKey, parameterValue)
    }
}
