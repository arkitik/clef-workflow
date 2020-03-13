package io.quee.api.develop.shared.model

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Fri Oct, 2019**
 */
class PageData<T>(
        val content: Iterable<T>,
        val numberOfElements: Int,
        val totalElements: Long,
        val totalPages: Int,
        val currentPage: Int,
        val currentPageSize: Int
)