package io.quee.clef.workflow.api.controller.stage.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.controller.stage.contract.StageApiContract
import io.quee.clef.workflow.api.controller.stage.dto.CreateStageRequestDto
import io.quee.clef.workflow.api.controller.stage.dto.StageRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.StageUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.response.stage.StageDetailsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class StageApiController(private val stageUseCaseFactory: StageUseCaseFactory) : StageApiContract {
    override fun CreateStageRequestDto.create(): ResponseEntity<ViewIdentify> {
        return stageUseCaseFactory.createStageUseCase
                .run {
                    ResponseEntity.ok(this@create.process())
                }
    }

    override fun details(key: String, uuid: String): ResponseEntity<StageDetailsResponse> {
        return stageUseCaseFactory.stageDetailsUseCase
                .run {
                    ResponseEntity.ok(StageRequestDto(key, uuid).process())
                }
    }

    override fun enable(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return stageUseCaseFactory.enableStageUseCase
                .run {
                    ResponseEntity.ok(StageRequestDto(key, uuid).process())
                }
    }

    override fun disable(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return stageUseCaseFactory.disableStageUseCase
                .run {
                    ResponseEntity.ok(StageRequestDto(key, uuid).process())
                }
    }

    override fun delete(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return stageUseCaseFactory.deleteStageUseCase
                .run {
                    ResponseEntity.ok(StageRequestDto(key, uuid).process())
                }
    }
}