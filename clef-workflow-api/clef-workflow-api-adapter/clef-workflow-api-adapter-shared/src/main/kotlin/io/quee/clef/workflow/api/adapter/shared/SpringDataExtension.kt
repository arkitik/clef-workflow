package io.quee.clef.workflow.api.adapter.shared

import io.quee.api.develop.shared.model.PageData
import org.springframework.data.domain.Page

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **07**, **Sat Mar, 2020**
 * Project [**pazar-store**](https://pazar.store/)<br></br>
 */

fun <I, E : I> Page<E>.toPageData(): PageData<I> {
    return PageData(content, numberOfElements, totalElements, totalPages, number, size)
}