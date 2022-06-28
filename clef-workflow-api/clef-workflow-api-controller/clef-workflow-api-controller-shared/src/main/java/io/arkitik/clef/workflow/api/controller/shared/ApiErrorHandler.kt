package io.arkitik.clef.workflow.api.controller.shared

import io.arkitik.clef.workflow.api.common.error.SharedErrors
import io.arkitik.radix.develop.shared.error.Error
import io.arkitik.radix.develop.shared.error.SharedException
import io.arkitik.radix.develop.shared.exception.*
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.handler.ExceptionHandlingWebHandler
import org.springframework.web.servlet.NoHandlerFoundException
import java.time.format.DateTimeParseException

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **20**, **Fri Mar, 2020**
 * Project **clef-workflow** [arkitik.IO](https://arkitik.io/)<br></br>
 */
@RestControllerAdvice
class ApiErrorHandler {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handle(e: HttpRequestMethodNotSupportedException): ResponseEntity<SingleErrorApiResponse> {
        logger.error("An error ", e)
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
            .body(SingleErrorApiResponse(Error(e.method, e.message)))
    }

    @ExceptionHandler(NoHandlerFoundException::class)
    fun handle(e: NoHandlerFoundException): ResponseEntity<SingleErrorApiResponse> {
        logger.error("An error ", e)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(SingleErrorApiResponse(Error(e.requestURL, e.message)))
    }

    @ExceptionHandler(InternalException::class)
    fun handle(e: InternalException): ResponseEntity<SingleErrorApiResponse> {
        logger.error("An error ", e)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(Exception::class)
    fun handle(e: Exception): ResponseEntity<SingleErrorApiResponse> {
        logger.error("An error ", e)
        e.printStackTrace()
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(SingleErrorApiResponse(SharedErrors.UNKNOWN_ERROR))
    }

    @ExceptionHandler(NotAcceptableException::class)
    fun handle(e: NotAcceptableException): ResponseEntity<SingleErrorApiResponse> {
        logger.error("An error ", e)
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
            .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(NotAuthorizedException::class)
    fun handle(e: NotAuthorizedException): ResponseEntity<SingleErrorApiResponse> {
        logger.error("An error ", e)
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handle(e: ResourceNotFoundException): ResponseEntity<SingleErrorApiResponse> {
        logger.error("An error ", e)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(UnprocessableEntityException::class)
    fun handle(e: UnprocessableEntityException): ResponseEntity<SingleErrorApiResponse> {
        logger.error("An error ", e)
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
            .body(SingleErrorApiResponse(e.error))
    }

    @ExceptionHandler(SharedException::class)
    fun handle(e: SharedException): ResponseEntity<ErrorApiResponse> {
        logger.error("An error ", e)
        return ResponseEntity.badRequest()
            .body(ErrorApiResponse(e.errors))
    }

    @ExceptionHandler(DateTimeParseException::class)
    fun handle(e: DateTimeParseException?): ResponseEntity<Error> {
        logger.error("An error ", e)
        return ResponseEntity.badRequest()
            .body(SharedErrors.INVALID_DATE_FORMAT)
    }
}
