package io.openads.adsmanager.common.input.rest.v1

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.support.WebExchangeBindException
import org.springframework.web.server.ServerWebExchange

@RestControllerAdvice
class RestControllerAdviceV1 {
    @ExceptionHandler(WebExchangeBindException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleWebExchangeBindException(
        e: WebExchangeBindException,
        exchange: ServerWebExchange,
    ): ErrorResponseV1 {
        val messages = e.bindingResult.allErrors.map { it.defaultMessage.toString() }

        return ErrorResponseV1(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.reasonPhrase,
            path = exchange.request.path.toString(),
            requestId = exchange.request.id,
            messages = messages,
        )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(
        e: IllegalArgumentException,
        exchange: ServerWebExchange,
    ): ErrorResponseV1 = ErrorResponseV1(
        status = HttpStatus.BAD_REQUEST.value(),
        error = HttpStatus.BAD_REQUEST.reasonPhrase,
        path = exchange.request.path.toString(),
        requestId = exchange.request.id,
        messages = listOf(e.message.toString()),
    )

    @ExceptionHandler(IllegalStateException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalStateException(
        e: IllegalStateException,
        exchange: ServerWebExchange,
    ): ErrorResponseV1 = ErrorResponseV1(
        status = HttpStatus.BAD_REQUEST.value(),
        error = HttpStatus.BAD_REQUEST.reasonPhrase,
        path = exchange.request.path.toString(),
        requestId = exchange.request.id,
        messages = listOf(e.message.toString()),
    )
}
