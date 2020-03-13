package io.quee.clef.workflow.api.usecase.factory.workflow.identify

import io.quee.api.develop.usecase.model.UseCaseResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **13**, **Fri Mar, 2020**
 * Project [**clef-workflow**](https://pazar.store/)<br></br>
 */
data class ViewIdentify(
        val uuid: String,
        val key: String
) : UseCaseResponse