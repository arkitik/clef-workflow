package io.quee.clef.workflow.api.controller.action.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.controller.action.contract.ActionApiContract
import io.quee.clef.workflow.api.controller.action.dto.CreateTaskActionRequestDto
import io.quee.clef.workflow.api.controller.action.dto.TaskActionRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskActionUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.identify.ViewIdentify
import io.quee.clef.workflow.api.usecase.factory.workflow.response.action.TaskActionDetails
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class ActionApiController(private val taskActionUseCaseFactory: TaskActionUseCaseFactory) : ActionApiContract {
    override fun CreateTaskActionRequestDto.create(): ResponseEntity<ViewIdentify> {
        return taskActionUseCaseFactory.createTaskActionUseCase
                .run {
                    ResponseEntity.ok(this@create.process())
                }
    }

    override fun details(key: String, uuid: String): ResponseEntity<TaskActionDetails> {
        return taskActionUseCaseFactory.taskActionDetailsUseCase
                .run {
                    ResponseEntity.ok(TaskActionRequestDto(key, uuid).process())
                }
    }

    override fun enable(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return taskActionUseCaseFactory.enableTaskActionUseCase
                .run {
                    ResponseEntity.ok(TaskActionRequestDto(key, uuid).process())
                }
    }

    override fun disable(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return taskActionUseCaseFactory.disableTaskActionUseCase
                .run {
                    ResponseEntity.ok(TaskActionRequestDto(key, uuid).process())
                }
    }

    override fun delete(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return taskActionUseCaseFactory.deleteTaskActionUseCase
                .run {
                    ResponseEntity.ok(TaskActionRequestDto(key, uuid).process())
                }
    }
}