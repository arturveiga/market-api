package br.com.veiga.application.handlers

import br.com.veiga.core.exceptions.BusinessException
import br.com.veiga.core.exceptions.MarketNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.OffsetDateTime
import java.util.stream.Collectors
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class ExceptionHandler(
    private val messageSource: MessageSource
) : ResponseEntityExceptionHandler() {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders, status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val problemType = INVALID_BODY
        val detail = "Invalid Body, attention in fields"
        val bindingResult = ex.bindingResult
        val problemObjects = bindingResult.allErrors.stream()
            .map { objectError: ObjectError ->
                val message: String = messageSource.getMessage(objectError, LocaleContextHolder.getLocale())
                var name: String = objectError.objectName
                if (objectError is FieldError) {
                    name = objectError.field
                }
                Problem.Object(
                    name = name,
                    userMessage = message
                )
            }
            .collect(Collectors.toList())
        val problem: Problem = createProblemBuilder(status, problemType, detail).copy(
            userMessage = detail,
            objects = problemObjects as List<Problem.Object>
        )

        return handleExceptionInternal(ex, problem, headers, status, request)
    }

    @ExceptionHandler(MarketNotFoundException::class)
    fun handleNotFoundException(ex: BusinessException, request: WebRequest): ResponseEntity<*> {
        val status = HttpStatus.NOT_FOUND
        val detail = ex.message
        val problem =
            createProblemBuilder(status, ERROR_BUSINESS, detail)
                .copy(
                    userMessage = detail
                )

        return handleExceptionInternal(ex, problem, HttpHeaders(), status, request)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException, request: WebRequest): ResponseEntity<*> {
        val status = HttpStatus.BAD_REQUEST
        val detail = ex.message
        val problem =
            createProblemBuilder(status, ERROR_BUSINESS, detail)
                .copy(
                    userMessage = detail
                )

        return handleExceptionInternal(ex, problem, HttpHeaders(), status, request)
    }

    override fun handleExceptionInternal(
        ex: Exception, body: Any?, headers: HttpHeaders,
        status: HttpStatus, request: WebRequest
    ): ResponseEntity<Any> {
        var body = body
        when {
            ex is EntityNotFoundException -> body = Problem(
                timestamp = OffsetDateTime.now(),
                title = status.reasonPhrase,
                status = status.value(),
                userMessage = DEFAULT_MESSAGE
            )
            body == null -> body = Problem(
                timestamp = OffsetDateTime.now(),
                title = status.reasonPhrase,
                status = status.value(),
                userMessage = DEFAULT_MESSAGE
            )
            body is String -> body = Problem(
                timestamp = OffsetDateTime.now(),
                title = body,
                status = status.value(),
                userMessage = DEFAULT_MESSAGE
            )
        }

        return super.handleExceptionInternal(ex, body, headers, status, request)
    }

    companion object {
        const val DEFAULT_MESSAGE = "Error on application :("
        const val ERROR_BUSINESS = "Business Violation"
        const val INVALID_BODY = "Body Invalid"
    }

    private fun createProblemBuilder(
        status: HttpStatus,
        problemType: String,
        detail: String?
    ): Problem {
        return Problem(
            timestamp = OffsetDateTime.now(),
            status = status.value(),
            detail = detail,
            title = problemType
        )
    }
}