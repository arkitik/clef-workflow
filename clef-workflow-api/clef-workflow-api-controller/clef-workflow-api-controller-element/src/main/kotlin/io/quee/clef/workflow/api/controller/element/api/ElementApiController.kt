package io.quee.clef.workflow.api.controller.element.api

import io.quee.api.develop.usecase.model.RequestAdapter
import io.quee.clef.workflow.api.common.response.SharedResponse
import io.quee.clef.workflow.api.common.response.ViewIdentify
import io.quee.clef.workflow.api.controller.element.contract.ElementApiContract
import io.quee.clef.workflow.api.controller.element.dto.CreateElementRequestDto
import io.quee.clef.workflow.api.controller.element.dto.ElementByUuidAndKeyDto
import io.quee.clef.workflow.api.controller.element.dto.ExecuteActionRequestDto
import io.quee.clef.workflow.api.usecase.factory.element.ElementUseCaseFactory
import io.quee.clef.workflow.api.usecase.factory.element.request.ElementByUuidAndKey
import io.quee.clef.workflow.api.usecase.factory.element.response.ElementFullDetailsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestController
class ElementApiController(
        private val elementUseCaseFactory: ElementUseCaseFactory
) : ElementApiContract {
    override fun CreateElementRequestDto.addElement(): ResponseEntity<ViewIdentify> {
        elementUseCaseFactory.createElementUseCase
                .run {
                    return ResponseEntity.ok(this@addElement.process())
                }
    }

    override fun ExecuteActionRequestDto.executeAction(): ResponseEntity<SharedResponse> {
        elementUseCaseFactory.executeActionIntoElementUseCase
                .run {
                    return ResponseEntity.ok(this@executeAction.process())
                }
    }

    override fun elementDetails(elementUuid: String, elementKey: String): ResponseEntity<ElementFullDetailsResponse> {
        elementUseCaseFactory.elementFullDetailsUseCase
                .run {
                    return ResponseEntity.ok(RequestAdapter<ElementByUuidAndKey>(ElementByUuidAndKeyDto(elementUuid, elementKey)).process())
                }
    }
}