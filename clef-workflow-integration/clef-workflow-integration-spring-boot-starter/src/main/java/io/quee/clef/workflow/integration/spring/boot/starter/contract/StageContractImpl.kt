package io.quee.clef.workflow.integration.spring.boot.starter.contract

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.stage.StageContract
import io.quee.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.CreateStageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.request.stage.StageRequest
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class StageContractImpl(private val stageUseCaseFactory: StageUseCaseFactory) : StageContract {
    override fun CreateStageRequest.create(): ContractResponse<ViewIdentify> {
        return stageUseCaseFactory.createStageUseCase
            .run {
                ContractResponse(this@create.process())
            }
    }

    override fun details(key: String): ContractResponse<StageDetailsResponse> {
        return stageUseCaseFactory.stageDetailsUseCase
            .run {
                ContractResponse(StageRequest(key).process())
            }
    }

    override fun enable(key: String): ContractResponse<SharedResponse> {
        return stageUseCaseFactory.enableStageUseCase
            .run {
                ContractResponse(StageRequest(key).process())
            }
    }

    override fun disable(key: String): ContractResponse<SharedResponse> {
        return stageUseCaseFactory.disableStageUseCase
            .run {
                ContractResponse(StageRequest(key).process())
            }
    }

    override fun delete(key: String): ContractResponse<SharedResponse> {
        return stageUseCaseFactory.deleteStageUseCase
            .run {
                ContractResponse(StageRequest(key).process())
            }
    }
}