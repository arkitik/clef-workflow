package io.quee.clef.workflow.api.usecase.factory.element.response

import io.quee.api.develop.usecase.model.UseCaseResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
class ElementFullDetailsResponse(
        val elementUuid: String,
        val elementKey: String,
        val currentTask: ElementDomainDetails,
        val currentStage: ElementDomainDetails,
        val currentWorkflow: ElementDomainDetails,
        val availableActions: List<ElementAvailableAction>
) : UseCaseResponse