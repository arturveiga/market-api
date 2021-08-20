package br.com.veiga.application.handlers

import br.com.veiga.core.exceptions.BusinessException
import br.com.veiga.core.exceptions.MarketNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(MarketNotFoundException::class)
    fun handleNotFoundException(ex: BusinessException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage(ex.message, ERROR_BUSINESS), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<*> {
        return ResponseEntity(ErrorMessage(ex.message, ex.bindingResult.toString()), HttpStatus.BAD_REQUEST)
    }

    companion object {
        const val ERROR_BUSINESS = "Business Violation"
    }

}