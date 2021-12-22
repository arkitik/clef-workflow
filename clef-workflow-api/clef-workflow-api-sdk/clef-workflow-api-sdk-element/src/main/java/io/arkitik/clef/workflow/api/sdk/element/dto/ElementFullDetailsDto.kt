package io.arkitik.clef.workflow.api.sdk.element.dto

/**
 * Created By [*Ibrahim Al-Tamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 19 10:57 PM, **Sun, December 2021**
 * Project *clef-workflow* [https://arkitik.io]
 */
data class ElementFullDetailsDto(
    val elementUuid: String,
    val elementKey: String,
    val currentTask: ElementDomainDetailsDto,
    val currentStage: ElementDomainDetailsDto,
    val currentWorkflow: ElementDomainDetailsDto,
    val availableActions: List<AvailableActionDto>,
)

data class ElementDomainDetailsDto(
    val name: String,
    val key: String,
    val uuid: String,
)

data class AvailableActionDto(
    val uuid: String,
    val key: String,
    val name: String,
    val parameters: List<AvailableActionParameterDto>,
)

data class AvailableActionParameterDto(
    val parameterName: String,
    val parameterValue: String,
)