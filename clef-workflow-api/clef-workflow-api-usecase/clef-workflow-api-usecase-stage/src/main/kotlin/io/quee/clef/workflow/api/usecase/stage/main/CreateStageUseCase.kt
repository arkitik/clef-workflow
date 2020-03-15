package io.quee.clef.workflow.api.usecase.stage.main

import io.quee.api.develop.action.usecase.validation.ValidationFunctionalUseCase
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.clef.workflow.api.common.error.StageResponses
import io.quee.clef.workflow.api.store.stage.StageStore
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **15**, **Sun Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class CreateStageUseCase(
        private val stageStore: StageStore
) : ValidationFunctionalUseCase<CreateStageRequest, ViewIdentify>() {
    override fun CreateStageRequest.extraValidation() {
        if (stageStore.storeQuery.existByKey(stageKey))
            throw NotAcceptableException(StageResponses.Errors.DUPLICATE_STAGE_ERROR)
    }

    override fun CreateStageRequest.realProcess(): ViewIdentify {
        val taskAction = stageStore.run {
            identityCreator()
                    .run {
                        stageKey.stageKey()
                        stageName.stageName()
                        create().save()
                    }
        }
        return ViewIdentify(taskAction.uuid, taskAction.stageKey)
    }
}