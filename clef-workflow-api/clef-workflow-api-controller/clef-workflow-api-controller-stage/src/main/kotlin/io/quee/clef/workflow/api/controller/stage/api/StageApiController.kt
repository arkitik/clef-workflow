package io.quee.clef.workflow.api.controller.stage.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.contract.shared.dto.ContractResponse
import io.quee.clef.workflow.api.contract.stage.dto.CreateStageRequestDto
import io.quee.clef.workflow.api.contract.stage.dto.StageRequestDto
import io.quee.clef.workflow.api.controller.stage.contract.StageApiContract
import io.quee.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class StageApiController(private val stageUseCaseFactory: StageUseCaseFactory) : StageApiContract {
    override fun CreateStageRequestDto.create(): ContractResponse<ViewIdentify> {
        return stageUseCaseFactory.createStageUseCase
                .run {
                    ContractResponse(this@create.process())
                }
    }

    override fun details(key: String, uuid: String): ContractResponse<StageDetailsResponse> {
        return stageUseCaseFactory.stageDetailsUseCase
                .run {
                    ContractResponse(StageRequestDto(key, uuid).process())
                }
    }

    override fun enable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return stageUseCaseFactory.enableStageUseCase
                .run {
                    ContractResponse(StageRequestDto(key, uuid).process())
                }
    }

    override fun disable(key: String, uuid: String): ContractResponse<SharedResponse> {
        return stageUseCaseFactory.disableStageUseCase
                .run {
                    ContractResponse(StageRequestDto(key, uuid).process())
                }
    }

    override fun delete(key: String, uuid: String): ContractResponse<SharedResponse> {
        return stageUseCaseFactory.deleteStageUseCase
                .run {
                    ContractResponse(StageRequestDto(key, uuid).process())
                }
    }
}