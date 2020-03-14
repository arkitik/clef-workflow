package io.quee.api.develop.usecase

import io.quee.api.develop.shared.error.Error
import java.util.stream.Collectors
import java.util.stream.StreamSupport
import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator as JavaXValidator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
class UseCaseValidator<T> private constructor() {
    private val validator: JavaXValidator = Validation.buildDefaultValidatorFactory().validator
    fun validate(item: T) {
        val violations = validator.validate(item)
        if (violations.size > 0) {
            val errors: List<Error> = violations.stream()
                    .map { violation: ConstraintViolation<T> -> createErrorMessage(violation) }
                    .collect(Collectors.toList())
            throw UseCaseException(errors)
        }
    }

    private fun createErrorMessage(violation: ConstraintViolation<T>): Error {
        val propertyPath = violation.propertyPath
        val message = violation.message
        val nodes = StreamSupport.stream(propertyPath.spliterator(), false)
                .collect(Collectors.toList())
        return if (nodes.isNotEmpty()) {
            Error(nodes[nodes.size - 1].name, message)
        } else Error(message, propertyPath.toString())
    }

    companion object {
        fun <T> newInstance(): UseCaseValidator<T> {
            return UseCaseValidator()
        }
    }

}