package io.quee.clef.workflow.api.controller.shared

import io.quee.api.develop.shared.MainErrors
import io.quee.api.develop.shared.error.Error
import io.quee.api.develop.shared.error.SharedException
import io.quee.api.develop.shared.exception.InternalException
import io.quee.api.develop.shared.exception.NotAcceptableException
import io.quee.api.develop.shared.exception.NotAuthorizedException
import io.quee.api.develop.shared.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.format.DateTimeParseException

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [Quee.IO](https://quee.io/)<br></br>
 */
@RestControllerAdvice
class ApiErrorHandler {
    @ExceptionHandler(InternalException::class)
    fun handle(e: InternalException): ResponseEntity<SingleErrorApiResponse> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(Exception::class)
    fun handle(e: Exception?): ResponseEntity<SingleErrorApiResponse> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(SingleErrorApiResponse(MainErrors.UNKNOWN_ERROR))
    }

    @ExceptionHandler(NotAcceptableException::class)
    fun handle(e: NotAcceptableException): ResponseEntity<SingleErrorApiResponse> {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(NotAuthorizedException::class)
    fun handle(e: NotAuthorizedException): ResponseEntity<SingleErrorApiResponse> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handle(e: ResourceNotFoundException): ResponseEntity<SingleErrorApiResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(SharedException::class)
    fun handle(e: SharedException): ResponseEntity<ErrorApiResponse> {
        return ResponseEntity.badRequest()
                .body(ErrorApiResponse(e.errors))
    }

    @ExceptionHandler(DateTimeParseException::class)
    fun handle(e: DateTimeParseException?): ResponseEntity<Error> {
        return ResponseEntity.badRequest()
                .body(MainErrors.SharedApi.INVALID_DATE_FORMAT)
    }
}