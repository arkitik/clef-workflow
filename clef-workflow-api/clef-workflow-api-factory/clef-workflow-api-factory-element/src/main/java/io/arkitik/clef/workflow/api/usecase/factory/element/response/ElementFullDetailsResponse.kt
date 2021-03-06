package io.arkitik.clef.workflow.api.usecase.factory.element.response

import io.arkitik.radix.develop.usecase.model.UseCaseResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class ElementFullDetailsResponse(
    val elementUuid: String,
    val elementKey: String,
    val currentTask: ElementDomainDetails,
    val currentStage: ElementDomainDetails,
    val currentWorkflow: ElementDomainDetails,
    val availableActions: List<ElementAvailableAction>,
) : UseCaseResponse