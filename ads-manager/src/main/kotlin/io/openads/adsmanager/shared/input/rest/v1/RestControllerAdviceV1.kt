package io.openads.adsmanager.shared.input.rest.v1

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestControllerAdviceV1 {
    @ExceptionHandler(BindException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBindException(
        e: BindException,
        request: HttpServletRequest,
    ): ErrorResponseV1 {
        val messages = e.bindingResult.allErrors.map { it.defaultMessage.toString() }

        return ErrorResponseV1(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.reasonPhrase,
            path = request.requestURI,
            requestId = request.requestId,
            messages = messages,
        )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(
        e: IllegalArgumentException,
        request: HttpServletRequest,
    ): ErrorResponseV1 = ErrorResponseV1(
        status = HttpStatus.BAD_REQUEST.value(),
        error = HttpStatus.BAD_REQUEST.reasonPhrase,
        path = request.requestURI,
        requestId = request.requestId,
        messages = listOf(e.message.toString()),
    )

    @ExceptionHandler(IllegalStateException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalStateException(
        e: IllegalStateException,
        request: HttpServletRequest,
    ): ErrorResponseV1 = ErrorResponseV1(
        status = HttpStatus.BAD_REQUEST.value(),
        error = HttpStatus.BAD_REQUEST.reasonPhrase,
        path = request.requestURI,
        requestId = request.requestId,
        messages = listOf(e.message.toString()),
    )
}
