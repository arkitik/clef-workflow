package io.arkitik.clef.workflow.api.usecase.factory.workflow.response.workflow.strcuture

import io.arkitik.radix.develop.usecase.model.UseCaseResponse
import io.arkitik.clef.workflow.api.common.response.ViewIdentify
import io.arkitik.clef.workflow.api.domain.shared.embedded.IdentityStatus

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **14**, **Sat Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
data class TaskActionStructure(
    val actionUuid: String,
    val actionKey: String,
    val actionName: String,
    val status: IdentityStatus,
    val actionDescription: String,
    val destinationTask: ViewIdentify,
) : UseCaseResponse