package io.quee.api.develop.usecase.model

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
interface UseCaseRequest {
    companion object {
        val NOP: UseCaseRequest = object : UseCaseRequest {}
    }
}