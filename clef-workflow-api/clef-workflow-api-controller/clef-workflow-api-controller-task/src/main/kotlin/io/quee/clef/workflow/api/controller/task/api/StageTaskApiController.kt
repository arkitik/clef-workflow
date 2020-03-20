package io.quee.clef.workflow.api.controller.task.api

import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.controller.task.contract.StageTaskApiContract
import io.quee.clef.workflow.api.controller.task.dto.CreateTaskRequestDto
import io.quee.clef.workflow.api.controller.task.dto.TaskRequestDto
import io.quee.clef.workflow.api.usecase.factory.workflow.TaskUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.workflow.response.task.TaskDetailsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **18**, **Wed Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class StageTaskApiController(private val taskUseCaseFactory: TaskUseCaseFactory) : StageTaskApiContract {
    override fun CreateTaskRequestDto.create(): ResponseEntity<ViewIdentify> {
        return taskUseCaseFactory.createTaskUseCase
                .run {
                    ResponseEntity.ok(this@create.process())
                }
    }

    override fun details(key: String, uuid: String): ResponseEntity<TaskDetailsResponse> {
        return taskUseCaseFactory.taskDetailsUseCase
                .run {
                    ResponseEntity.ok(TaskRequestDto(key, uuid).process())
                }
    }

    override fun enable(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return taskUseCaseFactory.enableTaskUseCase
                .run {
                    ResponseEntity.ok(TaskRequestDto(key, uuid).process())
                }
    }

    override fun disable(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return taskUseCaseFactory.disableTaskUseCase
                .run {
                    ResponseEntity.ok(TaskRequestDto(key, uuid).process())
                }
    }

    override fun delete(key: String, uuid: String): ResponseEntity<SharedResponse> {
        return taskUseCaseFactory.deleteTaskUseCase
                .run {
                    ResponseEntity.ok(TaskRequestDto(key, uuid).process())
                }
    }
}